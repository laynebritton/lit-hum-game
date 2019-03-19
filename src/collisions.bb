Function basic_attack_collisions()
	For char.fighter = Each fighter
		If char\state$ = "BASIC_ATTACK" Then
			For char2.fighter = Each fighter
				If (Not char\player# = char2\player#) Then
					offset = (offsetCalculator( ImageWidth(char\attack1), char\player))/char\basic_attack_frames
					For frame = 0 To char\basic_attack_frames 
						If ImagesCollide(char\attack1,char\x + offset,char\y, 0 , char2\body, char2\x, char2\y, 0) Then
							;Rect 0,0,200,200,1
							PlaySound char\basic_hit_sound
							char2\x = char2\x - offsetCalculator(200,char2\player)
						End If
					Next
				End If
			Next
		End If
	Next
End Function
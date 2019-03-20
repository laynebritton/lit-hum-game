Function basic_attack_collisions()
	For char.fighter = Each fighter
		If char\state$ = "BASIC_ATTACK" Then
			For char2.fighter = Each fighter
				If (Not char\player# = char2\player#) Then
					For frame = 0 To (char\basic_attack_frames -1) ;Frame counting logic
						;Body
						If ImagesCollide(char\attack1,char\attack_x,char\attack_y, frame, char2\body, char2\x, char2\y, 0) Then
							PlaySound char\basic_hit_sound
							char2\x = char2\x - offsetCalculator(200,char2\player)
						End If
						
						;Head
						If ImagesCollide(char\attack1,char\attack_x,char\attack_y, frame, char2\head, char2\x, char2\y, 0) Then
							PlaySound crit_sound
							char2\x = char2\x - offsetCalculator(200,char2\player)
						End If
					Next
				End If
			Next
		End If
	Next
End Function
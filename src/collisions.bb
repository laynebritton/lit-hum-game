Function basic_attack_collisions()
	For char.fighter = Each fighter
		If char\state$ = "BASIC_ATTACK" Then
			For char2.fighter = Each fighter
				If (Not char\player# = char2\player#) Then
					If ImagesCollide(char\attack1,char\attack_x,char\attack_y, 0, char2\body, char2\x, char2\y, 0) Then
						PlaySound char\basic_hit_sound
						char2\x = char2\x - offsetCalculator(200,char2\player)
					End If
				End If
			Next
		End If
	Next
End Function
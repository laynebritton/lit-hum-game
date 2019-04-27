Function mirrorImage(image)
	TFormImage(image,0,1,1,0)
	RotateImage(image,90)
	HandleImage(image,0,0)
End Function

Function offsetCalculator(amount#, player)
	If player = 2 Then
		Return (-1)*amount#
	Else 
		Return amount#
	End If
End Function 

Function deleteProjectiles()
	For entity.projectile = Each Projectile
		If entity\toDelete = True Then
			For char.fighter = Each Fighter
				If entity\player = char\player Then
					char\projectile_count = char\projectile_count - 1
				End If
			Next
			Delete entity
		End If
	Next
End Function

Function dealDamageTo(player,amount)
	For char.fighter = Each fighter
		If char\player = player Then
			char\hp= char\hp - amount
			If char\hp <= 0 Then 
				die(char\player)
				markAllProjectilesForDeletion()

				;addWin(char\player)
				;start_hightlight_state()
				
				For char2.fighter = Each fighter
					If (Not char2\player = char\player) And (Not char2\state$="DEAD") And (Not game_state$="BETWEEN") Then
						addWin(char2\player)
						
						If (char2\wins >= winsNeeded) Then
							start_highlight_state()
						Else 
							start_between_state()
						End If
					
					End If
				Next
				
				;nextRound()
			Else
				char\state$="HURT"
				char\invincibility_frames = char\invincibility_frames + 5
			End If
		End If
	Next
End Function 

Function nextRound()
	For char.fighter = Each fighter
		char\hp = char\max_hp
		char\x = char\start_x#
		char\y = char\start_y#
		char\state$ = "NONE"
	Next 
	currentRound = currentRound+1
	PlaySound(next_round_sound)
	FlushKeys()
End Function


Function gravity(strength#,height)
	For char.fighter = Each fighter
		If char\state$ = "DEAD" Then
			;Gravity for death
			If char\y# < height + ImageHeight(char\dead) Then
				;TODO: REMOVE char\movement_state$="LEFT"
				char\y# = char\y# + strength#
			End If
		Else If char\y#  + (ImageHeight(char\body) - height)< height Then
			;TODO: REMOVE char\movement_state$="RIGHT"
			char\y# = char\y# + strength#
		Else If char\y#  + (ImageHeight(char\body) - height)> height + 30 Then
			;TODO: REMOVE char\movement_state$="RIGHT"
			char\y# = char\y# - strength#
			;char\y# = char\y# + strength#
		End If
	Next
End Function

Function moveFighterX(direction$,player)
	For char.fighter = Each fighter
		If char\player = player And (Not char\state$="DEAD") Then
			If direction$ = "LEFT" Then
				char\movement_state$="LEFT"
				char\x# = char\x# - char\speed#
			Else If direction$ = "RIGHT" Then
				char\movement_state$="RIGHT"
				char\x# = char\x# + char\speed#
			End If
			
			walkAnimation(char\player)
			
		End If
	Next
End Function

Function moveFighterY(direction$,player)
	For char.fighter = Each fighter
		If char\player = player Then
			If direction$ = "UP" Then
				char\y# = char\y# - char\speed#
			Else If direction$ = "DOWN" Then
				char\y# = char\y# + char\speed#
			End If
		End If
	Next
End Function

Function basicAttack(player)
	For char.fighter = Each fighter
		If char\player = player And char\state$ = "NONE" And ((Not char\shield_state$ = "TRUE") Or (char\canAttackWhileShielding$="TRUE")) Then
			char\state$ = "BASIC_ATTACK"
		End If
	Next
End Function

Function updateProjectiles()
	For entity.projectile = Each Projectile
		entity\x# = entity\x# + offsetCalculator(entity\speed#,entity\player)
		entity\y# = entity\y# + entity\gravity#
		If entity\x# > 2220 Or entity\x# < -200 Then
			entity\toDelete = True
		End If
	Next
End Function 

Function jump(player)
	For char.fighter = Each fighter
		If char\player = player And (Not char\jump_state$ = "TRUE") And char\able_to_jump_state$ = "TRUE" And (Not char\state$="DEAD") Then
			char\jump_state$ = "TRUE"
			PlaySound char\jump_sound
		End If
	Next	
End Function

Function processJumps()
	For char.fighter = Each fighter
		If char\jump_state$ = "TRUE" Then
			char\y# = char\y# - char\jump_speed#
			
			char\jump_frame = char\jump_frame + 1
			
			If char\jump_frame >= char\jump_max_frame Then
				char\jump_frame = 0
				char\jump_state$ = "FALSE"
			End If
		End If
	Next
End Function

Function decrementInvincibilityFrames()
	For char.fighter = Each fighter
		If char\invincibility_frames > 0 Then
			char\invincibility_frames = char\invincibility_frames - 1
		Else If char\invincibility_frames <= 0 Then
			If char\state$="HURT" Then
				char\state$="NONE"
			End If
		End If
	Next
End Function


Function keepInBounds()
	For char.fighter = Each fighter
		If char\x# < -50 Then char\x# = -50
		If char\x# > 1870 Then char\x# = 1870
	Next
End Function			

Function playSoundAtFrame(current,target,sound)
	If current = target Then PlaySound(sound)
End Function

Function crouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\crouch_state$="TRUE"
		End If
	Next
End Function

Function unCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\crouch_state$="FALSE"
		End If
	Next
End Function

Function activateShield(player)
	For char.fighter = Each fighter
		If char\player = player And (Not char\state$="BASIC_ATTACK") Then
			char\shield_state$ ="TRUE"
		End If
	Next
End Function

Function deactivateShield(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\shield_state$ ="FALSE"
		End If
	Next
End Function 

Function markAllProjectilesForDeletion()
	For entity.projectile = Each Projectile
		entity\toDelete = True
	Next
End Function

Function clearProjectiles()
	For entity.projectile = Each Projectile
		Delete entity
	Next
End Function 

Function clearFighters()
	For char.fighter = Each fighter
		Delete char
	Next
End Function 

Function clearStages()
	For box.stage = Each stage
		Delete box
	Next
End Function

Function clearWins()
	For char.fighter = Each fighter
		char\wins=0
	Next
End Function

Function addWin(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\wins = char\wins + 1
		End If
	Next
End Function 

Function clearFight()
	game_state$="FIGHT_OVER"
	clearProjectiles()
	clearFighters()
	clearStages()
	currentRound=1
End Function

Function die(player)
	For char.fighter = Each fighter
		If char\player = player Then
			jump(char\player)
			char\state$ = "DEAD"
			PlaySound(char\death_sound)
			PlaySound(fighter_died_sound)
		End If
	Next
End Function		
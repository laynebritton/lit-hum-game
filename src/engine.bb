Function gravity(strength#,height)
	For char.fighter = Each fighter
		If char\state$ = "DEAD" Then
			;Gravity for death
			If char\y# < height + ImageHeight(char\dead) Then
				char\y# = char\y# + strength#
			End If
		Else If char\y# < height Then
			char\y# = char\y# + strength#
		End If
	Next
End Function

Function moveFighterX(direction$,player)
	For char.fighter = Each fighter
		If char\player = player And (Not char\state$="DEAD") Then
			If direction$ = "LEFT" Then
				char\x# = char\x# - char\speed#
			Else If direction$ = "RIGHT" Then
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
		If char\player = player And char\state$ = "NONE" Then
			char\state$ = "BASIC_ATTACK"
		End If
	Next
End Function

Function updateProjectiles()
	For entity.projectile = Each Projectile
		entity\x# = entity\x# + offsetCalculator(entity\speed#,entity\player)
		If entity\x# > 2220 Or entity\x# < -200 Then
			entity\toDelete = True
		End If
	Next
End Function 

Function jump(player)
	For char.fighter = Each fighter
		If char\player = player And (Not char\jump_state$ = "TRUE") And (char\y# >= floor_level) And (Not char\state$="DEAD") Then
			char\jump_state$ = "TRUE"
			PlaySound jump_sound
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

Function checkInput()
	;Kill-program 
	If KeyHit(1) Then
		End
	End If
	
	;Toggle FPS Display
	If KeyHit(2) Then
		toggleFpsDisplay()
	End If
	
	If KeyHit(3) Then
		togglePlayer1Coords()
	End If
	
	;Player 1 Movement
	If KeyHit(17) Then
		;Player 1 Move Up
		;moveFighterY("UP",1)
		jump(1)
	End If
	
	If KeyDown(31) Then
		;Player 1 Move Down
		;moveFighterY("DOWN",1)
		crouch(1)
	Else 
		uncrouch(1)
	End If

	If KeyDown(30) Then
		;Player 1 Move Left
		moveFighterX("LEFT",1)
	End If
	
	If KeyDown(32) Then
		;Player 1 Move Right
		moveFighterX("RIGHT",1)
	End If
	
	;Player 1 Actions
	If KeyHit(33) Then
		basicAttack(1)
	End If
	
	If KeyHit(46) Then
		createProjectile(1)
	End If
	
	;Player 2 Movement
	If KeyHit(200) Then
		;Player 2 Move Up
		;moveFighterY("UP",2)
		jump(2)
	End If
	
	If KeyDown(208) Then
		;Player 2 Move Down
		;moveFighterY("DOWN",2)
		crouch(2)
	Else 
		uncrouch(2)
	End If

	If KeyDown(203) Then
		;Player 2 Move Left
		moveFighterX("LEFT",2)
	End If
	
	If KeyDown(205) Then
		;Player 2 Move Right
		moveFighterX("RIGHT",2)
	End If
	
		;Player 2 Actions
	If KeyHit(34) Then
		basicAttack(2)
	End If
	
	If KeyHit(48) Then
		createProjectile(2)
	End If
	
	
End Function 
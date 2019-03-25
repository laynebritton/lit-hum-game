Function drawWorld()
	DrawImage(test_bg,0,0,0)
		
	drawFighters()
	drawProjectiles()
	drawFloorVisual()
	

	drawFightHUD()
	;Should always be last lines
	displayFPS(display_fps_on)
	displayPlayer1Coords(display_player1_coords_on)
	Flip
	Cls
End Function

Function drawFightHUD()
	drawFighterDisplayName()
	drawHealthBars()
	drawProjectilesAvailable()
End Function

Function drawFloorVisual()
	Color 128,128,128
	Rect 0,floor_level + 360,1920,10,1
End Function

Function drawProjectiles()
	For entity.projectile = Each Projectile
		DrawImage(entity\graphic,entity\x#,entity\y#,0)
	Next
End Function

Function drawFighterDisplayName()
	For char.fighter = Each fighter
		Color 255,0,255
		If char\player = 1 Then
			Text 400,75,char\display_name
		Else If char\player = 2 Then
			Text 1320,75,char\display_name
		End If
	Next
End Function 

Function drawHealthBars()
	For char.fighter = Each fighter
		Color 255,0,0
		If char\player = 1 Then
			Rect 400,100,(char\hp)*2,50
		Else If char\player = 2 Then
			Rect 1320 + (200 - (char\hp*2)),100,(char\hp)*2,50
		End If
	Next
End Function 

Function drawProjectilesAvailable()
	For char.fighter = Each fighter
		Color 255,255,0
		If char\player = 1 Then
			For i = 0 To (char\projectile_count_max - char\projectile_count) -1
				Oval 400 + i*(30), 175, 25,25,1
			Next
		End If
		If char\player = 2 Then
			For i = 0 To (char\projectile_count_max - char\projectile_count) -1
				Oval 1490 - i*(30), 175, 25,25,1
			Next
		End If
	Next
End Function 

Function drawFighters()
	For char.fighter = Each fighter
		;Print game\name
		Select char\name

		
		Case "Dante"
			
			drawDante()
			
		End Select
	Next
End Function


Function drawDante()
	For char.fighter = Each fighter
		If char\name = "Dante" Then 
			danteBreathing()	
			danteWalk(char\player)

			If char\crouch_state$="TRUE" Then
				danteCrouch(char\player)
			Else If char\crouch_state$="FALSE" Then 
				danteBody(char\player)
			End If
			
			If char\state$ = "NONE" Then
				DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#,0)
			Else If char\state$ = "BASIC_ATTACK" Then
				danteAttackAnimation()
			End If
			


		End If
	Next
End Function

Function danteBody(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x#
			char\head_y# = char\y#
			char\arm_y# = char\y#
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\body,char\x,char\y,0)

		End If
	Next 
End Function

Function danteCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x#
			char\head_y# = char\y# + 140
			char\arm_y# = char\y# + 70
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y,0)
		
		End If
	Next
End Function

Function danteWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\leg_x# = char\x# - offsetCalculator(10,char\player)
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk))
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function
			
			
Function danteAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "Dante" And char\state$ = "BASIC_ATTACK" Then 
			char\attack_x = char\x + offsetCalculator(100,char\player)
			char\attack_y = char\arm_y# - 60
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 15) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 15))
			
		End If
	Next 
End Function 

Function walkAnimation(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\walk_frame = char\walk_frame  + 1
			
			playsoundAtFrame(char\walk_frame,5,step_sound)
			
			If (char\walk_frame = 5) Then
				char\walk_draw_frame = char\walk_draw_frame + 1
			End If
			
			If char\walk_draw_frame > char\walk_max_draw_frame Then
				char\walk_draw_frame = 0
			End If
			
			If (char\walk_frame = 10) Then
				char\walk_frame = 0
			End If
			
			
		End If
	Next
End Function 

Function danteBreathing()
	For char.fighter = Each fighter
		If char\name = "Dante" Then 
			
			If char\breathingDirection$ = "UP" Then
				char\breathing# = char\breathing# - char\breathingSpeed#
			Else If char\breathingDirection$ = "DOWN" Then
				char\breathing# = char\breathing# + char\breathingSpeed#
			End If
			
			
			If char\breathing# < 2  Or char\breathing# > 5 Then
				If char\breathingDirection$ = "UP" Then
					char\breathingDirection$ = "DOWN" 
				Else If char\breathingDirection$ = "DOWN" Then
					char\breathingDirection$ = "UP"
				End If
			End If
			
		End If
	Next
End Function
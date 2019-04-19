Function drawWorld()
	drawStage()
			
	drawFloorVisual()
	
	;menuBubbles2()
	
	drawFightHUD()
	drawQuoteBoard()
	
	drawFighters()
	drawProjectiles()

	
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
	drawHighlight()
End Function

Function drawFloorVisual()
	Color 128,128,128
	;Rect 0,floor_level + 360,1920,10,1
End Function

Function drawHighlight()
	If game_state$ = "HIGHLIGHT" Then
		
		For char.fighter = Each fighter
			For char2.fighter = Each fighter
				If char2\state$ = "DEAD" Then
					If (Not char\state$ = "DEAD") Then
						Color 64,64,64
						Rect 0,0,1920,char\y#,1
						Rect 0, char\y# + ImageHeight(char\body), 1920,1080,1
					End If
				End If
			Next
		Next
	
	End If
End Function 

Function drawQuoteBoard()
	If game_state$="END" Then
		DrawImage(quote_board,400,50,0)
		For char.fighter = Each fighter
			If (Not char\state$ = "DEAD") Then writeQuote(char\win_quote)
		Next
	End If		
End Function

Function drawProjectiles()
	For entity.projectile = Each Projectile
		DrawImage(entity\graphic,entity\x#,entity\y#,0)
	Next
End Function

Function drawFighterDisplayName()
	For char.fighter = Each fighter
		;Color 59,82,73
		Color 44,87,132
		If char\player = 1 Then
			Text 400,75,char\display_name
		Else If char\player = 2 Then
			Text 1320,75,char\display_name
		End If
	Next
End Function 

Function drawHealthBars()
	For char.fighter = Each fighter
		Color 71,0,36
		If char\player = 1 Then
			Rect 400,100,(char\hp)*2,50
		Else If char\player = 2 Then
			Rect 1320 + (200 - (char\hp*2)),100,(char\hp)*2,50
		End If
	Next
End Function 

Function drawProjectilesAvailable()
	For char.fighter = Each fighter
		Color 44,87,132
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
		Select char\name
	
			Case "Dante"
			
				drawDante()
				
			Case "Don"
				drawDon()
				
			Case "Achilleus"
				drawAchilleus()
			
			Case "cly"
				drawCly()
				
			Case "Odysseus"
				drawOdysseus()
			
				
		End Select
	Next 
End Function


Function body(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x#
			char\head_y# = char\y#
			char\arm_y# = char\y#
			
			;DrawImage(char\head,char\head_x#,char\head_y#,0)
			DrawImage(char\body,char\x,char\y# + char\breathing#,0)
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			;DrawImage(char\body,char\x,char\y,0)

		End If
	Next 
End Function



Function walkAnimation(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\walk_frame = char\walk_frame  + 1
			
			playsoundAtFrame(char\walk_frame,5,char\step_sound)
			
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

Function drawBreathing()
	For char.fighter = Each fighter
		;If char\name = "Dante" Then 
			
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
			
		;End If
	Next
End Function


Function drawDeadFighter()
	For char.fighter = Each fighter	
		If char\state$ = "DEAD" Then
			DrawImage(char\dead,char\x#,char\y#,0)
		End If
	Next
End Function
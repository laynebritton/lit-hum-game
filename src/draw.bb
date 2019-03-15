Function drawWorld()
	DrawImage(test_bg,0,0,0)
	;DrawImage(test,player_x,player_y,0)
	
	drawFighters()
	drawFloorVisual()
	
	;Should always be last lines
	displayFPS(display_fps_on)
	displayPlayer1Coords(display_player1_coords_on)
	Flip
	Cls
End Function

Function drawFloorVisual()
	Color 128,128,128
	Rect 0,floor_level + 360,1920,10,1
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
			DrawImage(char\head,char\x,char\y + char\breathing#,0)
			DrawImage(char\body,char\x,char\y,0)
			
			If char\state$ = "NONE" Then
				DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\y,0)
			Else If char\state$ = "BASIC_ATTACK" Then
				danteAttackAnimation()
			End If
			
			
		End If
	Next
End Function

Function danteAttackAnimation()
	
	For char.fighter = Each fighter
		If char\name = "Dante" And char\state$ = "BASIC_ATTACK" Then 
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 30) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\x + offsetCalculator(80,char\player),char\y - 60,(char\attackAnimFrame / 30))
			
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
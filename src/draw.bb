Function drawWorld()
	DrawImage(test_bg,0,0,0)
	;DrawImage(test,player_x,player_y,0)
	
	drawFighters()
	
	;Should always be last lines
	displayFPS(display_fps_on)
	displayPlayer1Coords(display_player1_coords_on)
	Flip
	Cls
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
		If char\name = "Dante"

			DrawImage(char\body,char\x,char\y,0)
			
		
		End If
	Next
End Function
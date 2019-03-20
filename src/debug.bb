Function displayFPS(on)
	If on = 1 Then
		Color 255,242,0
		Text 0,0,"FPS: " + fps_to_display
	End If
End Function

Function displayPlayer1Coords(on)
	If on Then
		Color 255,242,0
		For char.fighter = Each fighter
			If char\player = 1 Then
				Text 0,25,char\x#
				Text 0,50,char\y#
			End If
		Next
	End If
End Function

Function toggleFpsDisplay()
	If display_fps_on = True Then
		display_fps_on = False
	Else 
		display_fps_on = True
	End If
End Function

Function togglePlayer1Coords()
	If display_player1_coords_on = True Then
		display_player1_coords_on = False
	Else 
		display_player1_coords_on = True
	End If
End Function
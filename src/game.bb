;Graphics Settings
Graphics 1920,1080,32,3
SetBuffer BackBuffer()

; Game-timing 
Const fps=60
Global elapsed#,period#=1000/fps,current#,lag#,previous#,fps_to_display,fps_time_tracker#
SeedRnd MilliSecs()


;Global Locations
Global player_x,player_y

;Global Media
Global test

;Global Values
Global fps_count,fake_count

;Game Settings
Global display_fps_on=True

loadGlobalImages()

Repeat

	While True
		lagCalculation()
		While lag# >= period#
			checkInput()

			;update world logic
			
			fps_count = fps_count + 1
			lag# = lag# - period#

		Wend
		
		fpsTracker()

		drawWorld()
	Wend

Forever


Function drawWorld()
	DrawImage(test,player_x,player_y,0)
	
	;Should always be last three lines
	displayFPS(display_fps_on)
	Flip
	Cls
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
	
	If KeyDown(17) Then
		player_y = player_y - 5
	End If
	
	If KeyDown(31) Then
		player_y = player_y + 5
	End If

	If KeyDown(30) Then
		player_x = player_x - 5
	End If
	
	If KeyDown(32) Then
		player_x = player_x + 5
	End If
	
End Function 

Function toggleFpsDisplay()
	If display_fps_on = True Then
		display_fps_on = False
	Else 
		display_fps_on = True
	End If
End Function

Function lagCalculation()
	current = MilliSecs()
	elapsed# = current# - previous#
	previous# = current#
	lag = lag + elapsed
End Function


Function fpsTracker()
		If MilliSecs() - fps_time_tracker# >= 1000 Then
			fps_to_display = fps_count
			fps_count = 0
			fps_time_tracker# = MilliSecs()
		End If
End Function

Function displayFPS(on)
	If on = 1 Then
		Text 0,0,fps_to_display
	End If
End Function

Function loadGlobalImages()
	test = LoadImage("../img/char.png")
	MaskImage(test,255,255,255)
End Function

Function initGlobalValues()
	;fps
	previous# = MilliSecs()
	fps_time_tracker# = MilliSecs()
	lag# = 0.0
	fps_count = 0


	player_x = 0
	player_y = 0
End Function
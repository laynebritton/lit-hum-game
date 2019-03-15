;Graphics Settings
Graphics 1920,1080,32,2
SetBuffer BackBuffer()

; Game-timing 
Const fps=60
Global elapsed#,period#=1000/fps,current#,lag#,previous#,fps_to_display,fps_time_tracker#
SeedRnd MilliSecs()


;Global Locations
Global player_x,player_y

;Global Media
Global test
Global test_bg

;Global Values
Global fps_count,fake_count

;Game Settings
Global display_fps_on=True

loadGlobalImages()

Repeat
	createFighter("Dante")
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
	DrawImage(test_bg,0,0,0)
	;DrawImage(test,player_x,player_y,0)
	
	drawFighters()
	
	;Should always be last three lines
	displayFPS(display_fps_on)
	Flip
	Cls
End Function

.fighterCreationAndDrawing

Function createFighter(fighterName$)

	Select fighterName$
	
	Case "Dante"
	;Dante
		char.fighter = New Fighter
			char\name$ = "Dante"
			
			;Location		
			char\x = 0
			char\y = 120
			
			;Stats
			char\hp = 100
			char\strength = 5
			char\speed = 10
			
			;Graphics
			char\body = LoadImage("../img/Dante/dante-resized.png")
			MaskImage(char\body,255,0,220)
	
	End Select
	
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

Function checkInput()
	;Kill-program 
	If KeyHit(1) Then
		End
	End If
	
	;Toggle FPS Display
	If KeyHit(2) Then
		toggleFpsDisplay()
		mirrorImage(test)
	End If
	
	If KeyDown(17) Then
		player_y = player_y - 10
	End If
	
	If KeyDown(31) Then
		player_y = player_y + 10
	End If

	If KeyDown(30) Then
		player_x = player_x - 10
	End If
	
	If KeyDown(32) Then
		player_x = player_x + 10
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
	test = LoadImage("../img/Dante/dante-resized.png")
	test_bg = LoadImage("../img/bg/acropolis.png")
	MaskImage(test,255,0,220)
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

Function mirrorImage(image)
	TFormImage(image,0,1,1,0)
	RotateImage(image,90)
	HandleImage(image,0,0)
End Function


Type Fighter
	Field name$
	
	;Graphics
	Field body
	
	;Physical Locations
	Field x#
	Field y#
	
	;Stats
	Field hp
	Field strength
	Field speed

End Type
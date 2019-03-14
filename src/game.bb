;Graphics Settings
Graphics 1920,1080,32,3
SetBuffer BackBuffer()

; Game-timing 
Const fps=60
Global elapsed,time,tween#,period=1000/fps
SeedRnd MilliSecs()


;Global Locations
Global player_x,player_y

;Global Media
Global test

;Global Values
Global fps_count,fake_count

loadGlobalImages()

Repeat
	fake_count = fake_count + 1
	Text 0,25,fake_count
	
	If fpsTracker() Then
	
		fps_count = fps_count + 1
		If fps_count > 60 Then
			;fps_count = 0
		End If
		Text 0,0,fps_count
		checkInput()
		DrawImage(test,player_x,player_y,0)
	
		Flip
		Cls
	
	End If

Forever



Function fpsTracker()
		Repeat
			elapsed=MilliSecs()-time
		Until elapsed
	
		tween#=Float(elapsed)/Float(period)
	
		While tween>=1
			Return True 
		Wend
		
		Return False 
		
End Function


Function checkInput()
	;Kill-program 
	If KeyHit(1) Then
		End
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


Function loadGlobalImages()
	test = LoadImage("../img/char.png")
	MaskImage(test,255,255,255)
End Function

Function initGlobalValues()
	player_x = 0
	player_y = 0
	fps_count = 0
	fake_count = 0
End Function
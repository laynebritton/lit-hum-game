Global stagebg

Function drawCharacterSelect()
	DrawImage(stagebg,0,0)
	
	Flip 
	Cls
End Function

Function characterSelect()
	checkCharacterSelectInput()
	drawCharacterSelect()
End Function 

Function loadMenuGraphics()
	stagebg = LoadImage("../img/bg/menu-bg.png")

End Function



Function fight(player1$,player2$,stage)
	loadingScreenQuote()
	loadStage(selected_stage$)
	SetFont font
	createFighter(player1$,1)
	createFighter(player2$,2)
	
	frameTimer=CreateTimer(60)
	
	PlaySound song
	fight_state = True
	While fight_state
		WaitTimer(frameTimer)

		checkInput()
			
		refreshWorld()
		
		drawWorld()
		
		For char.fighter = Each fighter
			If char\state$= "DEAD" Then
				fight_state = False
			End If
		Next
	Wend
	
	For char.fighter = Each fighter
		Delete char
	Next
	
End Function


 
Function loadingScreenQuote()
	writeQuote(1)
	Text 0,1020,"Loading..."	
	
	Flip
	Cls
End Function

Function checkCharacterSelectInput()
	If KeyHit(1) Then		
		fight(player_1_char, player_2_char, select_stage$)
	End If 
	
	If KeyHit(2) Or KeyHit(player1_jump) Then
		player_1_char$ = "Achilleus"
	End If
	
	If KeyHit(3) Or KeyHit(player1_throw) Then
		 player_1_char$ = "Dante"
	End If
	
	If KeyHit(4) Or KeyHit(player1_attack) Then
		 player_1_char$ = "Don"
	End If

	If KeyHit(5) Or KeyHit(player1_down) Then
		 player_1_char$ = "cly"
	End If
	
	If KeyHit(2) Or KeyHit(player2_jump) Then
		 player_2_char$ = "Achilleus"
	End If
	
	If KeyHit(3) Or KeyHit(player2_throw) Then
		 player_2_char$ = "Dante"
	End If
	
	If KeyHit(4) Or KeyHit(player2_attack) Then
		 player_2_char$ = "Don"
	End If
		
	If KeyHit(5) Or KeyHit(player2_down) Then
		 player_2_char$ = "cly"
	End If
End Function
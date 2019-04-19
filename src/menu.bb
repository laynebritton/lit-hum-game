;Yes the menu code is janky and kinda sucks
;Please don't hate on it, I slapped it together really fast if you can't tell lol
Global stagebg

Global charFrame
Global danteIcon,donIcon,achilleusIcon,clyIcon


Global p1Arrow,p2Arrow
Global p1Char,p2Char
Global p1Position=1, p2Position=1

Global maxMenuRectangles,currentMenuRectangles

Function drawCharacterSelect()
	boundArrows()
	;DrawImage(stagebg,0,0)

	drawCharacterIcons()
	drawPlayerArrows()
	getCharacterForArrows()

	menuBubbles()
	Flip 
	Cls
End Function

Function loadMenuAssets()
	loadMenuGraphics()
	loadMenuMusic()
	maxMenuRectangles = 120
	currentMenuRectangles = 0

End Function

Function characterSelect()
	checkCharacterSelectInput()
	drawCharacterSelect()
End Function 

Function loadMenuGraphics()
	stagebg = LoadImage("../img/bg/menu-bg.png")
	p1Arrow = LoadImage("../img/menu/p1-2.png")
	MaskImage(p1Arrow ,255,0,220)

	p2Arrow = LoadImage("../img/menu/p2-2.png")
	MaskImage(p2Arrow ,255,0,220)

End Function

Function loadMenuMusic()
	menuMusic = LoadSound("../snd/bgm/pillar-trap.mp3")
	LoopSound menuMusic
	SoundVolume menuMusic,0.5
End Function

Function drawCharacterIcons()
	x_increment = 125
	x_offset = 167
	y_position = 850
	For x = 1 To 10
		Select x
			Case 1
				DrawImage(achilleusIcon,x_increment *x + x_offset, y_position, 0)
			Case 2
				DrawImage(danteIcon,x_increment *x + x_offset, y_position, 0)
			Case 3
				DrawImage(donIcon,x_increment *x + x_offset, y_position, 0)
			Case 4
				DrawImage(clyIcon,x_increment *x + x_offset, y_position, 0)
		
		End Select

		DrawImage(charFrame,x_increment *x + x_offset, y_position, 0)
		
	Next	
		
End Function

Function drawPlayerArrows()
	DrawImage(p1Arrow,p1Position * 125 + 167, 720,0)
	DrawImage(p2Arrow,p2Position * 125 + 167,720,0)
End Function

Function getCharacterForArrows()
	Select p1Position
		Case 1
			player_1_char$ = "Achilleus"
		Case 2
			player_1_char$ = "Dante"
		Case 3
			player_1_char$ = "Don"
		Case 4
			player_1_char$ = "cly"
		Case 5
			player_1_char$ = "Odysseus"
		End Select
		
	Select p2Position
		Case 1
			player_2_char$ = "Achilleus"
		Case 2
			player_2_char$ = "Dante"
		Case 3
			player_2_char$ = "Don"
		Case 4
			player_2_char$ = "cly"
		Case 5
			player_2_char$ = "Odysseus"
		
		End Select
		
End Function

Function loadCharacterIcons()
	charFrame = LoadImage("../img/menu/char-frame.png")
	MaskImage(charFrame,255,0,220)
	danteIcon = LoadImage("../img/menu/dante-small.png")
	donIcon = LoadImage("../img/menu/don-small.png")
	achilleusIcon = LoadImage("../img/menu/achilleus-small.png")
	clyIcon = LoadImage("../img/menu/cly-small.png")


End Function

Function fight(player1$,player2$,stage)
	PauseChannel menuMusicChannel
	;TODO Get rid of this shit
	crapStageSelect()
	
	loadingScreenQuote()
	
	loadStage(selected_stage$)
	SetFont font
	createFighter(player1$,1)
	createFighter(player2$,2)
	
	frameTimer=CreateTimer(60)

	fightChannel = PlaySound(song)
	fight_state = True
	clear_game_states()
	While (Not game_state$ ="FIGHT_OVER")
		WaitTimer(frameTimer)

		checkInput()
			
		refreshWorld()
		
		drawWorld()
		
	Wend
	
	StopChannel(fightChannel)
	ResumeChannel menuMusicChannel
	clearFight()
	
End Function


Function incrementArrow(number)
	Select number
		Case 1
			p1Position = p1Position + 1
		Case 2
			p2Position = p2Position + 1
		
	End Select
End Function 

Function decrementArrow(number)
	Select number
		Case 1
			p1Position = p1Position - 1
		Case 2
			p2Position = p2Position - 1
		
	End Select
End Function 



Function boundArrows()
	If p1Position > 5 Then p1Position = 1
	If p2Position > 5 Then p2Position = 1
	
	If p1Position < 1 Then p1Position = 5
	If p2Position < 1 Then p2Position = 5
End Function 


 
Function loadingScreenQuote()
	writeQuote(1)
	Text 0,1020,"Loading..."	
	
	Flip
	Cls
End Function

Function checkCharacterSelectInput()
	If KeyHit(1) Then
		End 		
	End If 
	
	If KeyHit(player1_start) Then
		fight(player_1_char, player_2_char, select_stage$)
	End If
	
	If KeyHit(player1_right) Then
		incrementArrow(1)
	End If
	
	If KeyHit(player1_left) Then
		decrementArrow(1)
	End If

	If KeyHit(player2_right) Then
		incrementArrow(2)
	End If
	
	If KeyHit(player2_left) Then
		decrementArrow(2)
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

Function menuBubbles()
	If currentMenuRectangles< maxMenuRectangles Then 											
		currentMenuRectangles = currentMenuRectangles + 1
		menu.menu_rect = New menu_rect 
		For menu.menu_rect = Each menu_rect
			menu\x = Rand(15,1900)
			menu\y = Rand(0,1080)
			menu\speed = Rand(6,13)
		Next
	End If


	For menu.menu_rect = Each menu_rect
		;Color Rand(68,128),Rand(68,128),Rand(68,129)
		Color 128,128,128
		Oval menu\x,menu\y,2,50,1
		menu\y = menu\y - menu\speed 
		If menu\y < -10 Then
			menu\y = 1100
			menu\speed = Rand(6,13)
			menu\x = Rand(15,1900)
		End If
	Next 

End Function 

Function menuBubbles2()
	If currentMenuRectangles< maxMenuRectangles Then 											
		currentMenuRectangles = currentMenuRectangles + 1
		menu.menu_rect = New menu_rect 
		For menu.menu_rect = Each menu_rect
			menu\x = Rand(15,1900)
			menu\y = Rand(0,1080)
			menu\speed = Rand(13,20)
		Next
	End If


	For menu.menu_rect = Each menu_rect
		;Color Rand(68,128),Rand(68,128),Rand(68,129)
		Color 128,128,128
		Oval menu\x,menu\y,50,2,1
		menu\x = menu\x - menu\speed 
		If menu\x < -100 Then
			menu\x = 2020
			menu\speed = Rand(13,20)
			menu\y = Rand(0,1080)
		End If
	Next 

End Function 
;Yes the menu code is janky and kinda sucks
;Please don't hate on it, I slapped it together really fast if you can't tell lol
Global stagebg

Global charFrame
Global danteIcon,donIcon,achilleusIcon,clyIcon,odysseusIcon,aeneasIcon,elizabethIcon,satanIcon
Global danteSplash,donSplash,achilleusSplash,clySplash,odysseusSplash,aeneasSplash,elizabethSplash,satanSplash
Global danteSplash2,donSplash2,achilleusSplash2,clySplash2,odysseusSplash2,aeneasSplash2,elizabethSplash2,satanSplash2

Global stageArrow
Global stageFrame,bigStageFrame 

Global troyIcon,hellIcon,symposiumIcon,towerIcon,boatIcon,didoIcon,thermopylaeIcon,darcyIcon
Global troySplash,hellSplash,symposiumSplash,towerSplash,boatSplash,didoSplash,thermopylaeSplash,darcySplash

Global p1Arrow,p2Arrow
Global p1Char,p2Char
Global p1Position=1, p2Position=7
Global p1Book, p2Book

Global selected_stage$="troy"
Global stagePosition=0
Global stageBook
Global toDrawStageSplash
Global stageDisplayName$

Global maxMenuRectangles,currentMenuRectangles

Global currentRound=1
Global stageSelectState=False

Function menuNavigator()
	If stageSelectState=False Then
		characterSelect()
	Else If stageSelectState=True Then
		stageSelect()
	End If
End Function 

Function drawCharacterSelect()
	boundArrows()
	DrawImage(stagebg,0,0)

	drawCharacterIcons()
	drawPlayerArrows()
	getCharacterForArrows()
	drawCharacterSplashes()

	menuBubbles()
	Flip 
	Cls
End Function

Function drawStageSelect()
	boundStageArrow()	
	DrawImage(stagebg,0,0)

	drawStageArrow()
	getStageForArrow()
	drawStageIcons()
	drawStageSplash()
	
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


Function stageSelect()
	checkStageSelectInput()
	drawStageSelect()
End Function 


Function loadMenuGraphics()
	stagebg = LoadImage("../img/bg/gradient-bg.png")
	p1Arrow = LoadImage("../img/menu/p1-2.png")
	MaskImage(p1Arrow ,255,0,220)

	p2Arrow = LoadImage("../img/menu/p2-2.png")
	MaskImage(p2Arrow ,255,0,220)
	
	stageArrow = LoadImage("../img/menu/stage-arrow-2.png")
	MaskImage(stageArrow,255,0,220)
	stageFrame = LoadImage("../img/menu/stage-frame.png")
	MaskImage(stageFrame,255,0,220)
	bigStageFrame = LoadImage("../img/menu/big-stage-frame.png")
	MaskImage(bigStageFrame,255,0,220)

End Function

Function loadMenuMusic()
	menuMusic = LoadSound("../snd/bgm/menu.wav")
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
			Case 5
				DrawImage(odysseusIcon,x_increment *x + x_offset, y_position, 0)
			Case 6
				DrawImage(aeneasIcon,x_increment *x + x_offset, y_position, 0)			
			Case 7
				DrawImage(elizabethIcon,x_increment *x + x_offset, y_position, 0)				
			Case 8
				DrawImage(satanIcon,x_increment *x + x_offset, y_position, 0)

		End Select

		DrawImage(charFrame,x_increment *x + x_offset, y_position, 0)
		
	Next	
		
End Function

Function drawCharacterSplashes()
	drawP1 = False
	Color 0,0,0
	SetFont(big_quote_font)
		
	Select player_1_char$ 
		Case "Achilleus"
			p1Splash = achilleusSplash
			p1Book = Iliad
			
			Text 240,100,"Achilleus, Son of Peleus"
			drawP1 = True
		Case "Don"
			p1Splash = donSplash
			p1Book = Quixote
			Text 240,100,"Don Quixote de La Mancha"
			drawP1 = True
		Case "Dante"
			p1Splash = danteSplash
			p1Book = Inferno
			Text 240,100,"Dante Alighieri"

			drawP1 = True
		Case "cly"
			p1Splash = clySplash
			p1Book = Oresteia
			Text 240,100,"Clytaemestra"
			drawP1 = True
		Case "Odysseus"
			p1Splash = odysseusSplash
			p1Book = Odyssey
			Text 240,100,"Odysseus, Son of Laertes"
			drawP1 = True
		
		Case "Aeneas"
			p1Splash = aeneasSplash
			p1Book = Aeneid
			Text 240,100,"Aeneas, Son of Anchises"
			drawP1 = True
		
		Case "Elizabeth"
			p1Splash = elizabethSplash
			p1Book = Pride
			Text 240,100,"Elizabeth Bennet"
			drawP1 = True

		Case "Satan"
			p1Splash = satanSplash
			p1Book = lost
			Text 240,100,"Satan"
			drawP1 = True

		Default
			drawP1 = False
	End Select

	If drawP1 Then 
		DrawImage(p1Splash,240,150,0)
		DrawImage(p1Book,20,350,0)
		Color 0,0,0
		Rect 240,150,ImageWidth(p1Splash),ImageHeight(p1Splash),0	
	End If		
	

	drawP2 = False
	Color 0,0,0
	
	Select player_2_char$ 
		Case "Achilleus"
			p2Splash = achilleusSplash2
			p2Book = Iliad
			Text 1030,100,"Achilleus, Son of Peleus"
			
			drawP2 = True
		Case "Don"
			p2Splash = donSplash2
			p2Book = Quixote
			Text 1030,100,"Don Quixote de La Mancha"

			drawP2 = True
		Case "Dante"
			p2Splash = danteSplash2
			p2Book = Inferno
			Text 1030,100,"Dante Alighieri"

			drawP2 = True
		Case "cly"
			p2Splash = clySplash2
			p2Book = Oresteia
			Text 1030,100,"Clytaemestra"

			drawP2 = True
		Case "Odysseus"
			p2Splash = odysseusSplash2
			p2Book = Odyssey
			Text 1030,100,"Odysseus, Son of Laertes"

			drawP2 = True
			
		Case "Aeneas"
			p2Splash = aeneasSplash2
			p2Book = Aeneid
			Text 1030,100,"Aeneas, Son of Anchises"
			drawP2 = True

		Case "Elizabeth"
			p2Splash = elizabethSplash2
			p2Book = Pride
			Text 1030,100,"Elizabeth Bennet"
			drawP2 = True
			
		Case "Satan"
			p2Splash = satanSplash2
			p2Book = lost
			Text 1030,100,"Satan"
			drawP2 = True
			
		Default
			drawP2 = False
	End Select

	If drawP2 Then 
		DrawImage(p2Splash,1030,150,0)
		DrawImage(p2Book,1700,350,0)
		Color 0,0,0
		Rect 1030,150,ImageWidth(p2Splash),ImageHeight(p2Splash),0
	End If		

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
		Case 6
			player_1_char$ = "Aeneas"
		Case 7
			player_1_char$ = "Elizabeth"
		Case 8
			player_1_char$ = "Satan"
		Case 9
			player_1_char$ = "Aias"
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
		Case 6
			player_2_char$ = "Aeneas"
		Case 7
			player_2_char$ = "Elizabeth"
		Case 8
			player_2_char$ = "Satan"		
		Case 9
			player_2_char$ = "Aias"
		End Select
		
End Function

Function loadCharacterIcons()
	charFrame = LoadImage("../img/menu/char-frame.png")
	MaskImage(charFrame,255,0,220)
	danteIcon = LoadImage("../img/menu/dante-small.png")
	donIcon = LoadImage("../img/menu/don-small.png")
	achilleusIcon = LoadImage("../img/menu/achilleus-small.png")
	clyIcon = LoadImage("../img/menu/cly-small.png")
	odysseusIcon = LoadImage("../img/menu/odysseus-small.png")
	aeneasIcon = LoadImage("../img/menu/aeneas-small.png")
	elizabethIcon = LoadImage("../img/menu/elizabeth-small.png")
	satanIcon = LoadImage("../img/menu/satan-small.png")

End Function

Function loadCharacterSplashes()
	danteSplash = LoadImage("../img/menu/dante-big.png")
	MaskImage(danteSplash,255,0,220)
	donSplash = LoadImage("../img/menu/don-big.png")
	achilleusSplash = LoadImage("../img/menu/achilleus-big.png")
	clySplash = LoadImage("../img/menu/cly-big.png")
	odysseusSplash = LoadImage("../img/menu/odysseus-big.png")
	aeneasSplash = LoadImage("../img/menu/aeneas-big.png")
	elizabethSplash = LoadImage("../img/menu/elizabeth-big.png")
	MaskImage(elizabethSplash,255,0,220)
	satanSplash = LoadImage("../img/menu/satan-big.png")
	MaskImage(satanSplash,255,0,220)
	
	danteSplash2 = LoadImage("../img/menu/dante-big-2.png")
	MaskImage(danteSplash2,255,0,220)
	donSplash2 = LoadImage("../img/menu/don-big-2.png")
	achilleusSplash2 = LoadImage("../img/menu/achilleus-big-2.png")
	clySplash2 = LoadImage("../img/menu/cly-big-2.png")
	odysseusSplash2 = LoadImage("../img/menu/odysseus-big-2.png")
	aeneasSplash2 = LoadImage("../img/menu/aeneas-big-2.png")
	elizabethSplash2 = LoadImage("../img/menu/elizabeth-big-2.png")
	MaskImage(elizabethSplash2,255,0,220)
	satanSplash2 = LoadImage("../img/menu/satan-big-2.png")
	MaskImage(satanSplash2,255,0,220)

End Function

Function fight(player1$,player2$,stage)
	PauseChannel menuMusicChannel
	;TODO Get rid of this shit
	;crapStageSelect()
	
	loadingScreenQuote()
	
	loadStage(selected_stage$)
	SetFont font
	createFighter(player1$,1)
	createFighter(player2$,2)
	
	frameTimer=CreateTimer(60)

	fightChannel = PlaySound(song)
	fight_state = True
	clear_game_states()
	clearWins()
	While (Not game_state$ ="FIGHT_OVER")
		WaitTimer(frameTimer)

		If (Not game_state$="BETWEEN") And (Not isTransitionOnScreen()) Then
			checkInput()
		End If 
			
		refreshWorld()
		
		drawWorld()
		
	Wend
	
	StopChannel(fightChannel)
	ResumeChannel menuMusicChannel
	clearFight()
	stageSelectState=False

End Function


Function incrementArrow(number)
	PlaySound blipSound
	Select number
		Case 1
			p1Position = p1Position + 1
		Case 2
			p2Position = p2Position + 1
		
	End Select
End Function 

Function decrementArrow(number)
	PlaySound blipSound
	Select number
		Case 1
			p1Position = p1Position - 1
		Case 2
			p2Position = p2Position - 1
		
	End Select
End Function 

Function boundArrows()
	If p1Position > 10 Then p1Position = 1
	If p2Position > 10 Then p2Position = 1
	
	If p1Position < 1 Then p1Position = 10
	If p2Position < 1 Then p2Position = 10
	
End Function 

Function loadStageIconsAndSplashes()
	troyIcon = LoadImage("../img/menu/stage/troy-icon.png")
	MaskImage(troyIcon,255,0,220)
	
	troySplash = LoadImage("../img/menu/stage/troy-splash.png")
	MaskImage(troySplash,255,0,220)

	hellIcon = LoadImage("../img/menu/stage/hell-icon.png")
	MaskImage(hellIcon,255,0,220)
	
	hellSplash = LoadImage("../img/menu/stage/hell-splash.png")
	MaskImage(hellSplash,255,0,220)
	
	symposiumIcon = LoadImage("../img/menu/stage/symposium-icon.png")
	MaskImage(symposiumIcon,255,0,220)

	symposiumSplash = LoadImage("../img/menu/stage/symposium-splash.png")
	MaskImage(symposiumSplash,255,0,220)

	towerIcon = LoadImage("../img/menu/stage/tower-icon.png")
	MaskImage(towerIcon,255,0,220)

	towerSplash = LoadImage("../img/menu/stage/tower-splash.png")
	MaskImage(towerSplash,255,0,220)
	
	boatIcon = LoadImage("../img/menu/stage/boat-icon.png")
	MaskImage(boatIcon,255,0,220)

	boatSplash = LoadImage("../img/menu/stage/boat-splash.png")
	MaskImage(boatSplash,255,0,220)
	
	didoIcon = LoadImage("../img/menu/stage/dido-icon.png")
	MaskImage(didoIcon,255,0,220)
	
	didoSplash = LoadImage("../img/menu/stage/dido-splash.png")
	MaskImage(didoSplash,255,0,220)
	
	thermopylaeIcon = LoadImage("../img/menu/stage/thermopylae-icon.png")
	MaskImage(thermopylaeIcon,255,0,220)
	
	thermopylaeSplash = LoadImage("../img/menu/stage/thermopylae-splash.png")
	MaskImage(thermopylaeSplash,255,0,220)

	darcyIcon = LoadImage("../img/menu/stage/darcy-icon.png")
	MaskImage(darcyIcon,255,0,220)
	
	darcySplash = LoadImage("../img/menu/stage/darcy-splash.png")
	MaskImage(darcySplash,255,0,220)
End Function

Function incrementStageArrow(amount)
	PlaySound blipSound
	stagePosition = stagePosition + amount
End Function

Function decrementStageArrow(amount)
	PlaySound blipSound
	stagePosition = stagePosition - amount 
End Function

Function boundStageArrow()	
	If stagePosition = -1 Then
		stagePosition = 9
	Else If stagePosition <= -2 Then
		stagePosition = stagePosition +10
	Else If stagePosition = 10 Then
		stagePosition = 0
	Else If stagePosition >= 11 Then
		stagePosition = stagePosition - 10
	End If

End Function

Function getStageForArrow()
	Select stagePosition
		Case 0
			selected_stage$ = "troy"
			stageBook = aeneid
			toDrawStageSplash = troySplash
			stageDisplayName$ = "The Sack of Troy"
		Case 1
			selected_stage$ = "hell"
			stageBook = inferno
			toDrawStageSplash = hellSplash
			stageDisplayName$ = "9th Circle of Hell"
		Case 2
			selected_stage$ = "symposium"
			stageBook = symposium
			toDrawStageSplash = symposiumSplash
			stageDisplayName$ = "Symposium"

		Case 3
			selected_stage$ = "tower"
			stageBook = essays
			toDrawStageSplash = towerSplash
			stageDisplayName$ = "Montaigne's Room"

		Case 4
			selected_stage$ = "carthage"
			stageBook = aeneid
			toDrawStageSplash = didoSplash
			stageDisplayName$ = "Leaving Dido"
		Case 5
			selected_stage$ = "polyphemus"
			stageBook = odyssey
			toDrawStageSplash = boatSplash
			stageDisplayName$ = "Taunting Polyphemus"
		Case 6
			selected_stage$ = "thermopylae"
			stageBook = histories
			toDrawStageSplash = thermopylaeSplash
			stageDisplayName$ = "Thermopylae"
		Case 7
			selected_stage$ = "darcy"
			stageBook = pride
			toDrawStageSplash = darcySplash
			stageDisplayName$ = "Mr. Darcy's House"
	End Select
End Function

Function drawStageIcons()
	
	For i = 0 To 4
		Select i
			Case 0
				DrawImage(troyIcon,225 + i*(300),75,0)
			Case 1
				DrawImage(hellIcon,225 + i*(300),75,0)
			Case 2
				DrawImage(symposiumIcon,225 + i*(300),75,0)
			Case 3
				DrawImage(towerIcon,225 + i*(300),75,0)				
			Case 4
				DrawImage(didoIcon,225 + i*(300),75,0)
		End Select
		DrawImage(stageFrame,225 + i*(300),75,0)
	Next
	
	For i = 0 To 4
		Select i
			Case 0
				DrawImage(boatIcon,225 + i*(300),330,0)
			Case 1
				DrawImage(thermopylaeIcon,225 + i*(300),330,0)
			Case 2
				DrawImage(darcyIcon,225 + i*(300),330,0)	
		End Select
		DrawImage(stageFrame,225 + i*(300),330,0)
	Next
End Function

Function drawStageSplash()
	DrawImage(toDrawStageSplash,225,515,0)
	DrawImage(bigStageFrame,225,515,0)
	DrawImage(stageBook,1135,724,0)
	Color 0,0,0
	Text 1135,515,stageDisplayName$
End Function

Function drawStageArrow()
	If stagePosition <= 4 Then
		DrawImage(stageArrow,225 + (stagePosition*(300)),0,0)
	Else If stagePosition >= 5 Then
		DrawImage(stageArrow,225 + ((stagePosition-5)*(300)),225,0)
	End If
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
		;fight(player_1_char, player_2_char, select_stage$)
		stageSelectState=True
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
		
End Function

Function checkStageSelectInput()
	If KeyHit(1) Then
		End
	End If 
	
	If KeyHit(player1_start) Then
		fight(player_1_char, player_2_char, selected_stage$)
	End If

	If KeyHit(player1_right) Or KeyHit(player2_right) Then
		incrementStageArrow(1)
	End If
	
	If KeyHit(player1_left) Or KeyHit(player2_left) Then
		decrementStageArrow(1)
	End If
	
	If KeyHit(player1_down) Or KeyHit(player2_down) Then
		incrementStageArrow(5)
	End If
	
	If KeyHit(player1_up) Or KeyHit(player2_up) Then
		decrementStageArrow(5)
	End If
	
	If KeyHit(player1_throw) Or KeyHit(player2_throw) Then
		stageSelectState=False
	End If
	
End Function

Function menuBubbles()
	If currentMenuRectangles< maxMenuRectangles Then 											
		currentMenuRectangles = currentMenuRectangles + 1
		menu.menu_rect = New menu_rect 
		For menu.menu_rect = Each menu_rect
			menu\x = Rand(15,1900)
			menu\y = Rand(0,1080)
			menu\speed = Rand(8,15)
		Next
	End If


	For menu.menu_rect = Each menu_rect
		;Color Rand(68,128),Rand(68,128),Rand(68,129)
		Color 128,128,128
		Oval menu\x,menu\y,2,50,1
		menu\y = menu\y - menu\speed 
		If menu\y < -10 Then
			menu\y = 1100
			menu\speed = Rand(8,15)
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
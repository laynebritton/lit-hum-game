;Graphics Settings
Graphics3D 1920,1080,32,2
SetBuffer BackBuffer()

Include "controls.bb"
Include "framerate.bb"
Include "debug.bb"
Include "util.bb"
Include "factory.bb"
Include "draw.bb"
Include "types.bb"
Include "engine.bb"
Include "update.bb"
Include "collisions.bb"
Include "quotes.bb"
Include "stage.bb"

;Fighter Files
Include "dante.bb"
Include "don.bb"
Include "Achilleus.bb"

; Game-timing 
Const fps=60
Global elapsed#,period#=1000/fps,current#,lag#,previous#,fps_to_display,fps_time_tracker#
SeedRnd MilliSecs()


;Global Meta-game setting
Global floor_level=400
Global game_state$
Global game_state_timer

;Global Media
Global test
Global character_collision_sound,step_sound,jump_sound,projectile_collide_sound,fighter_died_sound,ding
Global quote_board
Global song

;Global Values
Global player_1_char$="Achilleus",player_2_char$="Dante"
Global selected_stage$="tower"
Global fps_count,fake_count

;Game Settings
Global display_fps_on=False,display_player1_coords_on=False

;Font
Global font,big_quote_font
;General Quotes
Dim quote_out$(8)

crapChooseCharacter()
loadGlobalMedia()

Repeat	


	loadingScreenQuote()
	loadStage(selected_stage$)
	SetFont font
	createFighter(player_1_char,1)
	createFighter(player_2_char,2)
	frameTimer=CreateTimer(60)
	
	PlaySound song
	While True
		WaitTimer(frameTimer)

		checkInput()
			
		refreshWorld()
		
		drawWorld()
	Wend

Forever

Function crapChooseCharacter()
	FlushKeys()

	Print "Player 1 select charcter"
	Print "1: Achilleus"
	Print "2: Dante"
	Print "3: Don Quixote"
	;Print "4: Hektor"
	
	WaitKey
	
	If KeyHit(2) Then
		 player_1_char = "Achilleus"
	End If
	
	If KeyHit(3) Then
		 player_1_char = "Dante"
	End If
	
	If KeyHit(4) Then
		 player_1_char = "Don"
	End If

	If KeyHit(5) Then
		 player_1_char = "Hektor"
	End If

	FlushKeys()
	
	Print "Player 2 select charcter"
	WaitKey
	
	If KeyHit(2) Then
		 player_2_char = "Achilleus"
	End If
	
	If KeyHit(3) Then
		 player_2_char = "Dante"
	End If
	
	If KeyHit(4) Then
		 player_2_char = "Don"
	End If
		
	If KeyHit(5) Then
		 player_2_char = "Hektor"
	End If
	FlushKeys()
	
	Print""
	Print"Select Stage"
	Print "1: 9th Circle of Hell"
	Print "2: Montaigne's Room"
	Print "3: Symposium"
	WaitKey
	
	If KeyHit(2) Then
		 selected_stage$ = "hell"
	End If
	
	If KeyHit(3) Then
		 selected_stage$ = "tower"
	End If
	
	If KeyHit(4) Then
		 selected_stage$ = "symposium"
	End If
	
	Flip
	Cls
End Function
 
Function loadingScreenQuote()
	writeQuote(1)
	Text 0,1020,"Loading..."	
	
	Flip
	Cls
End Function

Function loadGlobalMedia()
	font = LoadFont("Lucida Sans",22)
	big_quote_font = LoadFont("Lucida Sans",32)
	
	quote_board = LoadImage("../img/quote-board-3.png")
	
	character_collision_sound = LoadSound("../snd/sfx/gbl/character_collision.wav")
	jump_sound = LoadSound("../snd/sfx/jump.wav")
	projectile_collide_sound = LoadSound("../snd/sfx/gbl/projectile-collide.wav")
	fighter_died_sound = LoadSound("../snd/sfx/gbl/die2.wav")
	ding = LoadSound("../snd/sfx/gbl/ding.wav")
	SoundVolume song,.35
End Function

Function initGlobalValues()
	;fps
	previous# = MilliSecs()
	fps_time_tracker# = MilliSecs()
	lag# = 0.0
	fps_count = 0
End Function
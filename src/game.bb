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
Include "menu.bb"
Include "books.bb"

;Fighter Files
Include "fighters/dante.bb"
Include "fighters/don.bb"
Include "fighters/Achilleus.bb"
Include "fighters/clytaemestra.bb"
Include "fighters/Odysseus.bb"
Include "fighters/Aeneas.bb"
Include "fighters/Elizabeth.bb"

.Player1_Controls
Global player1_jump = 47
Global player1_down = 31
Global player1_left = 30
Global player1_right = 32
Global player1_attack = 33
Global player1_throw = 46
Global player1_start = 28

.Player2_Controls
Global player2_jump = 51
Global player2_down = 208
Global player2_left = 203
Global player2_right = 205
Global player2_attack = 37
Global player2_throw = 50

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
Global character_collision_sound,step_sound,jump_sound,projectile_collide_sound,fighter_died_sound,ding,next_round_sound

Global quote_board
Global song
Global channel
Global menuMusic
Global menuMusicChannel
Global blipSound

;Global Values
Global player_1_char$="Achilleus",player_2_char$="Elizabeth"
Global fps_count,fake_count
Global winsNeeded=2
;Game Settings
Global display_fps_on=False,display_player1_coords_on=False

;Font
Global font,big_quote_font
;General Quotes
Dim quote_out$(8)

;crapChooseCharacter()
loadGlobalMedia()
loadMenuAssets()
loadCharacterIcons()
loadCharacterSplashes()
loadBooks()

menuMusicChannel = PlaySound(menuMusic)
Repeat
	menuNavigator()
	;characterSelect()
Forever

Function crapStageSelect()
	FlushKeys()
	
	Print""
	Print"Select Stage"
	Print "A (1): 9th Circle of Hell"
	Print "B (2): Montaigne's Room"
	Print "X (3): Symposium"
	Print "  (4): Sack of Troy"
	Print "  (5): Departing Carthage"
	Print "  (6): Taunting the Giant"
	WaitKey
	
	If KeyHit(2) Or KeyHit(47)  Then
		 selected_stage$ = "hell"
	End If
	
	If KeyHit(3) Or KeyHit(46) Then
		 selected_stage$ = "tower"
	End If
	
	If KeyHit(4) Or KeyHit(33) Then
		 selected_stage$ = "symposium"
	End If
	
	If KeyHit(5) Or KeyHit(33) Then
		 selected_stage$ = "troy"
	End If
	
	If KeyHit(6) Or KeyHit(33) Then
		 selected_stage$ = "carthage"
	End If

	If KeyHit(7) Or KeyHit(33) Then
		 selected_stage$ = "polyphemus"
	End If
	
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
	blipSound = LoadSound("../snd/sfx/gbl/blip.wav")
	SoundVolume blipSound,.6	
	
	next_round_sound = LoadSound("../snd/sfx/gbl/next-round.wav")
	
	SoundVolume song,.35
	
End Function

Function initGlobalValues()
	;fps
	previous# = MilliSecs()
	fps_time_tracker# = MilliSecs()
	lag# = 0.0
	fps_count = 0
End Function
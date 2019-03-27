;Graphics Settings
Graphics 1920,1080,32,2
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

;Fighter Files
Include "dante.bb"
Include "don.bb"

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
Global test_bg
Global character_collision_sound,step_sound,jump_sound,projectile_collide_sound,fighter_died_sound
Global quote_board
Global song

;Global Values
Global fps_count,fake_count

;Game Settings
Global display_fps_on=False,display_player1_coords_on=False

;Font
Global font,big_quote_font
;General Quotes
Dim quote_out$(8)

loadGlobalMedia()

Repeat	
	loadingScreenQuote()
	
	SetFont font
	createFighter("Dante",1)
	createFighter("Don",2)
	frameTimer=CreateTimer(60)
	
	PlaySound song
	While True
		WaitTimer(frameTimer)

		checkInput()
			
		refreshWorld()
		
		drawWorld()
	Wend

Forever

Function loadingScreenQuote()
	writeQuote(1)
	Text 0,1020,"Loading..."	
	
	Flip
	Cls
End Function

Function loadGlobalMedia()
	font = LoadFont("Lucida Sans",22)
	big_quote_font = LoadFont("Lucida Sans",32)
	
	test_bg = LoadImage("../img/bg/hell.png")
	quote_board = LoadImage("../img/quote-board-3.png")
	
	character_collision_sound = LoadSound("../snd/sfx/gbl/character_collision.wav")
	jump_sound = LoadSound("../snd/sfx/jump.wav")
	projectile_collide_sound = LoadSound("../snd/sfx/gbl/projectile-collide.wav")
	fighter_died_sound = LoadSound("../snd/sfx/gbl/die2.wav")
	song  = LoadSound("../snd/bgm/menu.mp3")
	SoundVolume song,.35
End Function

Function initGlobalValues()
	;fps
	previous# = MilliSecs()
	fps_time_tracker# = MilliSecs()
	lag# = 0.0
	fps_count = 0
End Function
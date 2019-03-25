;Graphics Settings
Graphics 1920,1080,32,2
SetBuffer BackBuffer()

Include "framerate.bb"
Include "debug.bb"
Include "util.bb"
Include "factory.bb"
Include "draw.bb"
Include "types.bb"
Include "engine.bb"
Include "update.bb"
Include "collisions.bb"

; Game-timing 
Const fps=60
Global elapsed#,period#=1000/fps,current#,lag#,previous#,fps_to_display,fps_time_tracker#
SeedRnd MilliSecs()


;Global Meta-game setting
Global floor_level=400

;Global Media
Global test
Global test_bg
Global crit_sound,character_collision_sound

;Global Values
Global fps_count,fake_count

;Game Settings
Global display_fps_on=True,display_player1_coords_on=False

loadGlobalMedia()

Repeat
	createFighter("Dante",1)
	createFighter("Dante",2)
	frameTimer=CreateTimer(60)

	While True
		WaitTimer(frameTimer)
		lagCalculation()
			
		;While lag# >= period#
			checkInput()
			
			refreshWorld()
			;update world logic
			
		;	fps_count = fps_count + 1
		;	lag# = lag# - period#

		;Wend
		
		fpsTracker()

		drawWorld()
	Wend

Forever


Function loadGlobalMedia()
	test_bg = LoadImage("../img/bg/acropolis.png")
	crit_sound = LoadSound("../snd/sfx/thwack.wav")
	character_collision_sound = LoadSound("../snd/sfx/character_collision.wav")
End Function

Function initGlobalValues()
	;fps
	previous# = MilliSecs()
	fps_time_tracker# = MilliSecs()
	lag# = 0.0
	fps_count = 0
End Function
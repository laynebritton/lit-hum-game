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
Global elapsed#,period#=1000/fps,current#,lag#=0.0,previous#=MilliSecs(),fps_to_display,fps_time_tracker#=MilliSecs()
SeedRnd MilliSecs()


;Global Meta-game setting
Global floor_level=400

;Global Media
Global test
Global test_bg
Global crit_sound,character_collision_sound

;Global Values
Global fps_count=0,fake_count
Global current_frame=0

;Game Settings
Global display_fps_on=True,display_player1_coords_on=False

loadGlobalMedia()

Repeat
	createFighter("Dante",1)
	createFighter("Dante",2)
	yeet = MilliSecs()
	temp# = 0
	While True
		lagCalculation()
			
		While lag# >= period#
			checkInput()
			

			refreshWorld()
			;update world logic
			
			fps_count = fps_count + 1
			lag# = lag# - period#

		Wend
	
		fpsTracker()
		drawWorld()
		

	Wend

Forever


Function loadGlobalMedia()
	test_bg = LoadImage("../img/bg/acropolis.png")
	crit_sound = LoadSound("../snd/sfx/thwack.wav")
	character_collision_sound = LoadSound("../snd/sfx/character_collision.wav")
End Function

Function getCurrentFrame()
	Return current_frame;
End Function

Function setCurrentFrame(new_current_frame)
	current_frame = new_current_frame
End Function

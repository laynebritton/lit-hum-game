Function createFighter(fighterName$,player)

	Select fighterName$
	
	Case "Dante"
	;Dante
		char.fighter = New Fighter
			;Data
			char\name$ = "Dante"
			char\display_name$ = "Dante Alighieri"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 100
			char\strength = 5
			char\speed = 10
			char\projectile_count_max = 3
			char\projectile_speed# = 9
			char\projectile_damage = 4
			char\critMultiplier# = 2
			
			;Jump Stats
			char\jump_max_frame = 28
			char\jump_speed = 25
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.03
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			
			;Quotes
			char\win_quote = 2
			
			;Graphics
			char\body = LoadImage("../img/Dante/dante-body-4.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Dante/dante-head.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Dante/dante-arm.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Dante/dante-crouch-2.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Dante/dante-dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Dante/dante-walk.png",198,37,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Dante/dante-weapon-anim.png",198,360,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Dante/dante-projectile.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Dante/dante-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Dante/dante-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Dante/dante-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Dante/dante-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Dante/dante-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Dante/dante-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Dante/dante-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Dante/dante-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Dante/dante-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Dante/dante-kill.wav")
			
	Case "Don"
	;Don Quixote
		char.fighter = New Fighter
			;Data
			char\name$ = "Don"
			char\display_name$ = "Don Quixote de La Mancha"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = 0
			
			;Stats
			char\hp = 70
			char\strength = 9
			char\speed = 15
			char\projectile_count_max = 1
			char\projectile_speed# = 6
			char\projectile_damage = 5
			char\critMultiplier# = 2
			
			;Jump Stats
			char\jump_max_frame = 22
			char\jump_speed = 25
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.1
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			
			;Quotes
			char\win_quote = 3
			
			;Graphics
			char\body = LoadImage("../img/Don/don-body-2.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Don/don-head.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Don/don-arm-2.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Don/don-crouch.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Don/don-dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Don/don-walk-2.png",225,124,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Don/don-weapon-anim.png",500,90,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Don/don-projectile.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Don/don-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Don/don-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Don/don-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Don/don-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Don/don-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Don/don-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Don/don-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Don/don-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Don/don-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Don/don-kill.wav")
			
	Case "Achilleus"
	;Achilleus
		char.fighter = New Fighter
			;Data
			char\name$ = "Achilleus"
			char\display_name$ = "Achilleus, Son of Peleus"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 80
			char\strength = 6
			char\speed = 12
			char\projectile_count_max = 1
			char\projectile_speed# = 15
			char\projectile_gravity# = 12
			char\projectile_damage = 12
			char\critMultiplier# = 2
			char\knockback = 100
			;Jump Stats
			char\jump_max_frame = 28
			char\jump_speed = 29
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.07
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			char\shield_state$ ="FALSE"
			
			;Quotes
			char\win_quote = 4
			
			;Graphics
			char\body = LoadImage("../img/Achilleus/achilleus-body.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Achilleus/achilleus-head.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Achilleus/achilleus-arm.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Achilleus/achilleus-crouch.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Achilleus/achilleus-dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Achilleus/achilleus-walk.png",305,131,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Achilleus/achilleus-weapon-anim.png",200,200,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Achilleus/achilleus-spear-2.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Achilleus/achilleus-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Achilleus/achilleus-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Achilleus/achilleus-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")


	Case "Hektor"
	;Achilleus
		char.fighter = New Fighter
			;Data
			char\name$ = "Achilleus"
			char\display_name$ = "Hektor, Son of Priam"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 70
			char\strength = 5
			char\speed = 14
			char\projectile_count_max = 1
			char\projectile_speed# = 15
			char\projectile_gravity# = 12
			char\projectile_damage = 11
			char\critMultiplier# = 2
			char\knockback = 100
			;Jump Stats
			char\jump_max_frame = 28
			char\jump_speed = 29
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.07
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			char\shield_state$ ="FALSE"
			
			;Quotes
			char\win_quote = 4
			
			;Graphics
			char\body = LoadImage("../img/Hektor/achilleus-body.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Hektor/achilleus-head.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Hektor/achilleus-arm.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Hektor/achilleus-crouch.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Hektor/achilleus-dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Hektor/achilleus-walk.png",305,131,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Hektor/achilleus-weapon-anim.png",200,200,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Hektor/achilleus-spear-2.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Achilleus/achilleus-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Achilleus/achilleus-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Achilleus/achilleus-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")


	Case "cly"
	;Clytaemestra
		char.fighter = New Fighter
			;Data
			char\name$ = "cly"
			char\display_name$ = "Clytaemestra"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 65
			char\strength = 7
			char\speed = 12
			char\projectile_count_max = 4
			char\projectile_speed# = 13
			char\projectile_gravity# = 6
			char\projectile_damage = 4
			char\critMultiplier# = 2
			;char\knockback = 100
			
			;Jump Stats
			char\jump_max_frame = 24
			char\jump_speed = 24
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.05
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			
			;Quotes
			char\win_quote = 5
			
			;Graphics
			char\body = LoadImage("../img/Clytaemestra/body-3.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Clytaemestra/head-alt-2.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Clytaemestra/arm-4.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Clytaemestra/crouch-1.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Clytaemestra/dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Clytaemestra/walk-2.png",301,82,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Clytaemestra/attack-anim.png",500,550,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Clytaemestra/throw.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Dante/dante-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Dante/dante-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Dante/dante-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Dante/dante-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Dante/dante-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Dante/dante-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Dante/dante-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Dante/dante-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Dante/dante-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Dante/dante-kill.wav")
		

		
	Case "Odysseus"
	;Odysseus
		char.fighter = New Fighter
			;Data
			char\name$ = "Odysseus"
			char\display_name$ = "Odysseus, Son of Laertes"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 75
			char\strength = 7
			char\speed = 15
			char\projectile_count_max = 4
			char\projectile_speed# = 15
			char\projectile_gravity# = 3
			char\projectile_damage = 5
			char\critMultiplier# = 2.5
			char\knockback = 100
			;Jump Stats
			char\jump_max_frame = 26
			char\jump_speed = 30
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.07
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			char\shield_state$ ="FALSE"
			
			;Quotes
			char\win_quote = 6
			
			;Graphics
			char\body = LoadImage("../img/Odysseus/body-1.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Odysseus/head-1.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Odysseus/leg-2.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Odysseus/crouch-2.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Odysseus/dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Odysseus/walk-anim-2.png",337,134,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\cosmetic1 = LoadImage("../img/Odysseus/odysseus-arm-nohit-2.png")
			MaskImage(char\cosmetic1,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Odysseus/attack-anim.png",450,250,0,4)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 4
			
			char\projectile_graphic = LoadImage("../img/Odysseus/projectile.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				mirrorImage(char\cosmetic1)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Achilleus/achilleus-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Achilleus/achilleus-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Achilleus/achilleus-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")

	Case "Aeneas"
	;Aeneas
		char.fighter = New Fighter
			;Data
			char\name$ = "Aeneas"
			char\display_name$ = "Aeneas, Son of Anchises"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 90
			char\strength = 8
			char\speed = 12
			char\projectile_count_max = 2
			char\projectile_speed# = 15
			char\projectile_gravity# = 3
			char\projectile_damage = 4
			char\critMultiplier# = 2
			char\knockback = 100
			char\canAttackWhileShielding$="TRUE"
			char\canShootWhileShielding$="FALSE"
			;Jump Stats
			char\jump_max_frame = 28
			char\jump_speed = 26
			
			;Animation
			char\breathing# = 3
			char\breathingSpeed# = 0.05
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			char\shield_state$ ="FALSE"
			
			;Quotes
			char\win_quote = 7
			
			;Graphics
			char\body = LoadImage("../img/Aeneas/body-1.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Aeneas/head-2.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Aeneas/arm-2.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Aeneas/crouch.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Aeneas/dead-2.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Aeneas/walk-anim.png",320,215,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\cosmetic1 = LoadImage("../img/Aeneas/un-shield-4.png")
			MaskImage(char\cosmetic1,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Aeneas/attack-anim.png",400,300,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			
			char\projectile_graphic = LoadImage("../img/Odysseus/projectile.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				mirrorImage(char\cosmetic1)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Achilleus/achilleus-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Achilleus/achilleus-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Achilleus/achilleus-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
	
	
	Case "Elizabeth"
	;Elizabeth
		char.fighter = New Fighter
			;Data
			char\name$ = "Elizabeth"
			char\display_name$ = "Elizabeth Bennet"	
			char\player = player
			
			;Location		
			char\x = 600
			char\y = floor_level
			
			;Stats
			char\hp = 100
			char\strength = 6
			char\speed = 13
			char\projectile_count_max = 1
			char\projectile_speed# = 17
			char\projectile_gravity# = 0
			char\projectile_damage = 7
			char\critMultiplier# = 2
			char\knockback = 100
			char\canAttackWhileShielding$="FALSE"
			char\canShootWhileShielding$="TRUE"
			;Jump Stats
			char\jump_max_frame = 25
			char\jump_speed = 25
			
			;Animation
			char\breathing# = 3
			char\breathingSpeed# = 0.06
			char\breathingDirection$ = "UP"
			char\projectile_animation_frames = 1
			char\walk_frame = 0
			char\walk_draw_frame = 0
			char\walk_max_draw_frame = 1

			;State
			char\state$ = "NONE"
			char\shield_state$ ="FALSE"
			
			;Quotes
			char\win_quote = 7
			
			;Graphics
			char\body = LoadImage("../img/Elizabeth/body.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Elizabeth/head-2.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Elizabeth/arm-6.png")
			MaskImage(char\arm,255,0,220)
			char\crouch = LoadImage("../img/Elizabeth/crouch.png")
			MaskImage(char\crouch,255,0,220)
			char\dead = LoadImage("../img/Elizabeth/dead.png")
			MaskImage(char\dead,255,0,220)
			char\walk = LoadAnimImage("../img/Elizabeth/walk-2.png",200,24,0,2)
			MaskImage(char\walk,255,0,220)
			
			char\cosmetic1 = LoadImage("../img/Elizabeth/acc-1.png")
			MaskImage(char\cosmetic1,255,0,220)
			
			char\attack1 = LoadAnimImage("../img/Elizabeth//attack-anim.png",300,305,0,4)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 4
			
			char\projectile_graphic = LoadImage("../img/Elizabeth/collins-3.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1320 - ImageWidth(char\body)
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\crouch)
				mirrorImage(char\walk)
				mirrorImage(char\dead)
				mirrorImage(char\cosmetic1)
				
				mirrorImage(char\attack1)
				
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/Achilleus/achilleus-swing.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-basic-hit.wav")
			char\jump_sound = LoadSound("../snd/sfx/Achilleus/achilleus-jump.wav")
			char\step_sound = LoadSound("../snd/sfx/Achilleus/achilleus-step.wav")
			char\crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-crit.wav")
			char\projectile_throw_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-throw.wav")
			char\projectile_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-impact.wav")
			char\projectile_crit_sound = LoadSound("../snd/sfx/Achilleus/achilleus-projectile-crit.wav")
			char\kill_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
			char\death_sound = LoadSound("../snd/sfx/Achilleus/achilleus-kill.wav")
	
	End Select 
End Function

Function createProjectile(player)
	For char.fighter = Each fighter
		If char\player = player And char\projectile_count < char\projectile_count_max  And (Not char\state$="DEAD") And (Not ((char\shield_state$ = "TRUE") And (char\canShootWhileShielding$="FALSE"))) Then
			char\projectile_count = char\projectile_count + 1
			
			entity.projectile = New Projectile
				entity\player = char\player
				entity\graphic = char\Projectile_graphic
				entity\speed = char\Projectile_speed
				entity\damage = char\Projectile_damage
				entity\throw_sound = char\projectile_throw_sound
				entity\impact_sound = char\projectile_sound
				entity\crit_sound = char\projectile_crit_sound
				
				entity\x# = char\x#
				entity\y# = char\y#
				
				entity\animation_frames = char\projectile_animation_frames
				
				If (Not char\projectile_gravity = 0) Then
					entity\gravity# = char\projectile_gravity#
				End If
			
			Select char\name$
				
			Case "Dante"
				entity\x# = entity\x# - offsetCalculator(120,entity\player) 
				entity\y# = entity\y# + 130
			Case "Don"
				entity\x# = entity\x# - offsetCalculator(80,entity\player) 
				entity\y# = entity\y# + 200
			Case "Achilleus"
				;entity\x# = entity\x# - offsetCalculator(80,entity\player) 
				;entity\y# = entity\y# + 200
			Case "cly"
				entity\x# = entity\x# - offsetCalculator(120,entity\player) 
				entity\y# = entity\y# + 130
			Case "Odysseus"
				If entity\player = 1 Then
					entity\x# = entity\x# + offsetCalculator(180,entity\player) 
				End If 
				
				If entity\player =2 Then
					entity\x# = entity\x#; + offsetCalculator(180,entity\player) 
				End If 
				
				entity\y# = entity\y# + 100
				
			Case "Aeneas"
				If entity\player = 1 Then
					entity\x# = entity\x# + offsetCalculator(110,entity\player) 
					entity\y# = entity\y# + 50
				End If 
				
				If entity\player =2 Then
					entity\x# = entity\x# + offsetCalculator(30,entity\player) 
					entity\y# = entity\y# + 50
				End If 
				
				entity\y# = entity\y# + 100
			
			Case "Elizabeth"
				If entity\player = 1 Then
					entity\x# = -200
				End If 
				
				If entity\player =2 Then
					entity\x# = 2120 ;entity\x# + offsetCalculator(30,entity\player) 
				End If 
				
				entity\y# = floor_level
			End Select
				
			PlaySound char\projectile_throw_sound
		End If
	Next 
End Function
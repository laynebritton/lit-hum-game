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
			char\hp = 50
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
	End Select
	
End Function

Function createProjectile(player)
	For char.fighter = Each fighter
		If char\player = player And char\projectile_count < char\projectile_count_max  And (Not char\state$="DEAD") Then
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
			
			Select char\name$
				
			Case "Dante"
				entity\x# = entity\x# - offsetCalculator(120,entity\player) 
				entity\y# = entity\y# + 130
			End Select
				
			PlaySound char\projectile_throw_sound
		End If
	Next 
End Function
Function createFighter(fighterName$,player)

	Select fighterName$
	
	Case "Dante"
	;Dante
		char.fighter = New Fighter
			;Data
			char\name$ = "Dante"	
			char\player = player
			
			;Location		
			char\x = 490
			char\y = floor_level
			
			;Stats
			char\hp = 100
			char\strength = 5
			char\speed = 10
			char\projectile_count_max = 3
			char\projectile_speed# = 12
			char\projectile_damage = 3
			
			;Animation
			char\breathing# = 2
			char\breathingSpeed# = 0.03
			char\breathingDirection$ = "UP"
			
			;State
			char\state$ = "NONE"
			
			;Graphics
			char\body = LoadImage("../img/Dante/dante-body-3.png")
			MaskImage(char\body,255,0,220)
			char\head = LoadImage("../img/Dante/dante-head.png")
			MaskImage(char\head,255,0,220)
			char\arm= LoadImage("../img/Dante/dante-arm.png")
			MaskImage(char\arm,255,0,220)
			char\attack1 = LoadAnimImage("../img/Dante/dante-weapon-anim.png",198,360,0,5)
			MaskImage(char\attack1,255,0,220)
			char\basic_attack_frames = 5
			char\projectile_graphic = LoadImage("../img/Dante/dante-head.png")
			MaskImage(char\projectile_graphic,255,0,220)
			
			If player = 2 Then
				char\playerMultiplier = -1
				char\x = 1430
				mirrorImage(char\body)
				mirrorImage(char\head)
				mirrorImage(char\arm)
				mirrorImage(char\attack1)
				mirrorImage(char\projectile_graphic)
			End If
	
	
			;Sound
			char\swing_sound = LoadSound("../snd/sfx/swing2.wav")
			char\basic_hit_sound = LoadSound("../snd/sfx/hit/hit7.wav")
	End Select
	
End Function
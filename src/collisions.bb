;character_collision_sound
Function basic_attack_collisions()
	For char.fighter = Each fighter
		If char\state$ = "BASIC_ATTACK" Then
			For char2.fighter = Each fighter
				If (Not char\player# = char2\player#) Then
					For frame = 0 To (char\basic_attack_frames -1) ;Frame counting logic
						;Body
						If ImagesCollide(char\attack1,char\attack_x,char\attack_y, frame, char2\body, char2\x, char2\y, 0) And char\crouch_state$ = "FALSE" Then
							PlaySound char\basic_hit_sound
							dealDamageTo(char2\player, char\strength)
							char\x = char\x - offsetCalculator(30,char\player)
							char2\x = char2\x - offsetCalculator(200,char2\player)
						End If
						
						;Head
						If ImagesCollide(char\attack1,char\attack_x,char\attack_y, frame, char2\head, char2\head_x#, char2\head_y#, 0) Then
							PlaySound crit_sound
							dealDamageTo(char2\player, (char\strength) * char\critMultiplier#)
							char\x = char\x - offsetCalculator(30,char\player)
							char2\x = char2\x - offsetCalculator(200,char2\player)
						End If
					Next
				End If
			Next
		End If
	Next
End Function

Function fighter_movement_collision()
	For char.fighter = Each fighter
		For char2.fighter = Each fighter
			If (Not char\player# = char2\player#) Then
				If ImagesCollide(char\body,char\x,char\y, 0, char2\body, char2\x, char2\y, 0) Then
					PlaySound character_collision_sound
					char\x = char\x - offsetCalculator(30,char\player)					
					char2\x = char2\x - offsetCalculator(30,char2\player)
				End If
			End If
		Next
	Next
End Function

Function projectile_collisions()
	For entity.projectile = Each Projectile
		For char.fighter = Each fighter
			If (Not entity\player = char\player) Then
				For frame = 0 To entity\animation_frames -1
					;Body
					If ImagesCollide(entity\graphic, entity\x#, entity\y#, frame, char\body,char\x,char\y, 0) And char\crouch_state$ = "FALSE" Then
						PlaySound character_collision_sound
						dealDamageTo(char\player, entity\damage)
						entity\toDelete = True
					End If
					
					If ImagesCollide(entity\graphic, entity\x#, entity\y#, frame, char\head,char\head_x#,char\head_y#, 0) Then
						PlaySound crit_sound
						dealDamageTo(char\player, (entity\damage)*2)
						entity\toDelete = True
					End If
				Next
			End If
		Next
		
		For entity2.projectile = Each projectile
			If(Not entity\player = entity2\player) Then
				For frame = 0 To entity\animation_frames -1
					If ImagesCollide(entity\graphic, entity\x#, entity\y#, frame, entity2\graphic, entity2\x#, entity2\y#, frame) Then
						entity\toDelete = True
						entity2\toDelete = True
						PlaySound projectile_collide_sound
					End If
				Next
			End If
		Next
	Next
End Function 
						
Function drawAchilleus()
	For char.fighter = Each fighter
		If char\name = "Achilleus" Then 
			If char\state$ = "DEAD" Then
				drawDeadFighter()
			Else
				drawBreathing()	
				achilleusWalk(char\player)

				
				If char\state$ = "NONE" And char\crouch_state$="FALSE" Then
					DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#,0)
				Else If char\state$ = "BASIC_ATTACK" Then
					achilleusAttackAnimation()
				End If

				If char\crouch_state$="TRUE" Then
					activateShield(char\player)
					achilleusCrouch(char\player)
				Else If char\crouch_state$="FALSE" Then 
					deactivateShield(char\player)
					body(char\player)
				End If
				achilleusSpearHold(char\player)
			End If
		End If
	Next
End Function

Function achilleusSpearHold(player)
	For char.fighter = Each fighter
		If char\player = player Then
			If char\projectile_count_max - char\projectile_count > 0 Then
				DrawImage(char\projectile_graphic,char\x#,char\y#,0)
			End If
		End If
	Next
End Function

Function achilleusCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x# ;- offsetCalculator(0,char\player)
			char\head_y# = char\y# ;+ 0
			char\arm_x# = char\x# ;-offsetCalculator(0,char\player)
			char\arm_y# = char\y#; + 0
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y,0)
			
		End If
	Next
End Function


Function achilleusAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "Achilleus" And char\state$ = "BASIC_ATTACK" Then
			player_2_offset = 160
			If char\player=2 Then
				player_2_offset = ImageWidth(char\attack1) - 160
			End If
			
			char\attack_x = char\x + offsetCalculator(player_2_offset,char\player)
			 
			char\attack_y = char\arm_y# + 110
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 7) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 7))
			
		End If
	Next 
End Function 

Function achilleusWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			player_2_offset = 1
			If char\player=2 Then
				player_2_offset = -23
			End If
			
			char\leg_x# = char\x# + offsetCalculator(player_2_offset,char\player)
	
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk) -5)
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function

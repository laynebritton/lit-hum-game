Function drawSatan()
	For char.fighter = Each fighter
		If char\name = "Satan" Then 
			If char\state$ = "DEAD" Then
				drawDeadFighter()
			Else
				drawBreathing()	
				SatanWalk(char\player)
												

				If char\crouch_state$="TRUE" Then
					If char\state$ = "NONE" Then
						DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#+ char\breathing#,0)
					Else If char\state$ = "BASIC_ATTACK" Then
						SatanAttackArm(char\player)
						SatanAttackAnimation()
					End If
					
					activateShield(char\player)
					SatanCrouch(char\player)

				Else If char\crouch_state$="FALSE" Then 
					deactivateShield(char\player)
					
					SatanBow(char\player)
					body(char\player)
					
					If char\state$ = "NONE" Then
						DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#+ char\breathing#,0)
					Else If char\state$ = "BASIC_ATTACK" Then
						SatanAttackAnimation()
					End If
					
				End If
				
				

			End If
		End If
	Next
End Function

Function SatanArrowHold(player)
	For char.fighter = Each fighter
		If char\player = player Then
			If char\projectile_count_max - char\projectile_count > 0 Then

				player_2_offset = 215
				If char\player=2 Then
					player_2_offset = 5
				End If
				;x_offset = offsetCalculator(215,char\player)
				y_offset = 115 + char\breathing#
				If char\crouch_state$="TRUE" Then
					y_offset = y_offset + 90
				End If
				DrawImage(char\projectile_graphic,char\x# + player_2_offset,char\y# + y_offset,0)
			End If
		End If
	Next
End Function

Function SatanBow(player)
	For char.fighter = Each fighter
		If char\player = player Then
			DrawImage(char\cosmetic1,char\x#,char\arm_y# + char\breathing#,0)
		End If
	Next
End Function 

Function SatanAttackArm(player)
	For char.fighter = Each fighter
		If char\player = player Then
			DrawImage(char\cosmetic2,char\x#,char\arm_y# + char\breathing#,0)
		End If
	Next
End Function 

Function SatanCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x# ;- offsetCalculator(0,char\player)
			char\head_y# = char\y# ;+ 90 
			char\arm_x# = char\x# ;-offsetCalculator(0,char\player)
			char\arm_y# = char\y# ;+ 90+ char\breathing#
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y + char\breathing#,0)
			
		End If
	Next
End Function


Function SatanAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "Satan" And char\state$ = "BASIC_ATTACK" Then
			player_2_offset = 520
			If char\player=2 Then
				player_2_offset = 125;ImageWidth(char\attack1); - 160
			End If
			
			char\attack_x = char\x + offsetCalculator(player_2_offset,char\player)
			 
			char\attack_y = char\arm_y#; + 110
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 11) > char\basic_attack_frames - 1 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 11))
			
		End If
	Next 
End Function 

Function SatanWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			player_2_offset = 1
			If char\player=2 Then
				player_2_offset = -23
			End If
			
			char\leg_x# = char\x# ;+ offsetCalculator(player_2_offset,char\player)
	
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk) -5)
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function

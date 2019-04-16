Function drawCly()
	For char.fighter = Each fighter
		If char\name = "cly" Then 
			If char\state$ = "DEAD" Then
				drawDeadFighter()
			Else
				drawBreathing()	
				clyWalk(char\player)
	
				If char\crouch_state$="TRUE" Then
					clyCrouch(char\player)
				Else If char\crouch_state$="FALSE" Then 
					body(char\player)
				End If
				
				If char\state$ = "NONE" Then
					DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#,0)
				Else If char\state$ = "BASIC_ATTACK" Then
					clyAttackAnimation()
				End If
			
			End If
		End If
	Next
End Function

Function clyWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\leg_x# = char\x# - offsetCalculator(0,char\player)
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk)) - 8
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function


Function clyAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "cly" And char\state$ = "BASIC_ATTACK" Then 
			player_2_offset = 0
			If char\player=2 Then
				player_2_offset = 200;ImageWidth(char\attack1) + 200
			End If
			
			char\attack_x = char\x + offsetCalculator(player_2_offset,char\player)
			char\attack_y = char\arm_y#; - 60
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 8) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 8))
			
		End If
	Next 
End Function 

Function clyCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x#
			char\head_y# = char\y# + 220
			char\arm_y# = char\y# + 170
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y,0)
		
		End If
	Next
End Function

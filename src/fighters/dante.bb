Function drawDante()
	For char.fighter = Each fighter
		If char\name = "Dante" Then 
			If char\state$ = "DEAD" Then
				drawDeadFighter()
			Else
				drawBreathing()	
				danteWalk(char\player)
	
				If char\crouch_state$="TRUE" Then
					danteCrouch(char\player)
				Else If char\crouch_state$="FALSE" Then 
					body(char\player)
				End If
				
				If char\state$ = "NONE" Then
					DrawImage(char\arm,char\x - offsetCalculator(3, char\player),char\arm_y#,0)
				Else If char\state$ = "BASIC_ATTACK" Then
					danteAttackAnimation()
				End If
			
			End If
		End If
	Next
End Function

Function danteWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\leg_x# = char\x# - offsetCalculator(10,char\player)
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk))
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function


Function danteAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "Dante" And char\state$ = "BASIC_ATTACK" Then 
			char\attack_x = char\x + offsetCalculator(100,char\player)
			char\attack_y = char\arm_y# - 60
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,60,char\swing_sound)
			
			If (char\attackAnimFrame / 15) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 15))
			
		End If
	Next 
End Function 

Function danteCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x#
			char\head_y# = char\y# + 140
			char\arm_y# = char\y# + 70
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y,0)
		
		End If
	Next
End Function
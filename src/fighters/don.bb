Function drawDon()
	For char.fighter = Each fighter
		If char\name = "Don" Then 
			If char\state$ = "DEAD" Then
				drawDeadFighter()
			Else
				drawBreathing()	
				donWalk(char\player)
	
				If char\crouch_state$="TRUE" Then
					donCrouch(char\player)
				Else If char\crouch_state$="FALSE" Then 
					body(char\player)
				End If
				
				If char\state$ = "NONE" Then
					DrawImage(char\arm,char\x + offsetCalculator(10, char\player),char\arm_y# + 5,0)
				Else If char\state$ = "BASIC_ATTACK" Then
					donAttackAnimation()
				End If
			
			End If
		End If
	Next
End Function

Function donCrouch(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\head_x# = char\x# - offsetCalculator(30,char\player)
			char\head_y# = char\y# + 145
			char\arm_x# = char\x# -offsetCalculator(50,char\player)
			char\arm_y# = char\y# + 170
			
			DrawImage(char\head,char\head_x#,char\head_y#+ char\breathing#,0)
			DrawImage(char\crouch,char\x,char\y,0)
		
		End If
	Next
End Function


Function donAttackAnimation()
	For char.fighter = Each fighter
		If char\name = "Don" And char\state$ = "BASIC_ATTACK" Then 
			
			player_2_offset = 0
			If char\player=2 Then
				player_2_offset = ImageWidth(char\attack1) - 200
			End If
			
			char\attack_x = char\x + offsetCalculator(player_2_offset,char\player)
			
			char\attack_y = char\arm_y# + 270
			
			char\attackAnimFrame = char\attackAnimFrame + 1
		
			playsoundAtFrame(char\attackAnimFrame,1,char\swing_sound)
			playsoundAtFrame(char\attackAnimFrame,30,char\swing_sound)
			
			If (char\attackAnimFrame / 10) > 4 Then
				char\attackAnimFrame = 0
				char\state$ = "NONE"
			End If
			DrawImage(char\attack1,char\attack_x,char\attack_y,(char\attackAnimFrame / 10))
			
		End If
	Next 
End Function 

Function donWalk(player)
	For char.fighter = Each fighter
		If char\player = player Then
			char\leg_x# = char\x# ;+ offsetCalculator(71,char\player)		
			char\leg_y# = char\y# + (ImageHeight(char\body) - ImageHeight(char\walk) -5)
			DrawImage(char\walk,char\leg_x#,char\leg_y#,char\walk_draw_frame)
		End If
	Next
End Function

Function refreshWorld()
	game_states()

	decrementInvincibilityFrames()

	gravity(15,floor_level)
	keepInBounds()
	
	processJumps()
	able_to_jump_state()

	updateProjectiles()
	deleteProjectiles()
	
	fighter_movement_collision()	
	basic_attack_collisions()
	projectile_collisions()
	
End Function


Function game_states()
	Select game_state$
	
	Case "BETWEEN"
		inbetween_state()

	Case "HIGHLIGHT"
		highlight_state()

	End Select
	
End Function


Function highlight_state()
	If game_state_timer + 1500 < MilliSecs() Then
		game_state$ = "END"
	Else 
		Delay(150) 
	End If
End Function

Function inbetween_state()
	If game_state_timer + 3500 > MilliSecs() Then
		game_state$ = "BETWEEN"
	Else 
		game_state$ = ""
		nextRound()
	End If
End Function

Function start_highlight_state()
	game_state$ = "HIGHLIGHT"
	game_state_timer = MilliSecs()
End Function

Function start_between_state()
	game_state$ = "BETWEEN"
	game_state_timer = MilliSecs()
End Function

Function able_to_jump_state()
	For char.fighter = Each fighter
		If (char\y# + (ImageHeight(char\body) - floor_level) >= floor_level) Then
			char\able_to_jump_state$ = "TRUE"
		Else
			char\able_to_jump_state$ = "FALSE"
		End If
	Next	
End Function 


Function clear_game_states()
	game_state$=""
	highlight_state=""
End Function 
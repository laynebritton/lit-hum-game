Function refreshWorld()
	game_states()
	decrementInvincibilityFrames()

	gravity(15,floor_level)
	keepInBounds()
	
	processJumps()
	
	updateProjectiles()
	deleteProjectiles()
	
	fighter_movement_collision()	
	basic_attack_collisions()
	projectile_collisions()
	
End Function


Function game_states()
	Select game_state$
	
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

Function start_highlight_state()
	game_state$ = "HIGHLIGHT"
	game_state_timer = MilliSecs()
End Function
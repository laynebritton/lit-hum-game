Function refreshWorld()
	gravity(5,floor_level)
	
	updateProjectiles()
	deleteProjectiles()
	
	basic_attack_collisions()
	
	fighter_movement_collision()
End Function
Function refreshWorld()
	gravity(15,floor_level)
	keepInBounds()
	
	processJumps()
	
	updateProjectiles()
	deleteProjectiles()
	
	fighter_movement_collision()	
	basic_attack_collisions()
	projectile_collisions()
End Function
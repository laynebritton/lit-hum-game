Function refreshWorld()
	gravity(5,floor_level)
	
	updateProjectiles()
	deleteProjectiles()

	fighter_movement_collision()	
	basic_attack_collisions()
	projectile_collisions()
End Function
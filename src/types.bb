Type Fighter
	;Data
	Field name$
	Field player
	Field playerMultiplier=1
	
	;Graphics
	Field body
	Field head
	Field arm
	Field attack1
	Field projectile_graphic
	Field crouch
	Field walk
	
	;Animation
	Field breathing#
	Field breathingSpeed#
	Field breathingDirection$
	Field attackAnimFrame = 0
	Field walk_frame
	Field walk_draw_frame
	Field walk_max_draw_frame
	
	;Frame counts
	Field basic_attack_frames
	Field projectile_animation_frames
	
	;Physical Locations
	Field x#
	Field y#
	Field head_x#
	Field head_y#
	Field arm_y#
	Field leg_x#
	Field leg_y#
	
	;Jump Data
	Field jump_frame
	Field jump_max_frame
	Field jump_speed#
	
	;Attack data
	Field attack_x#=0
	Field attack_y#=0
	Field projectile_count
	
	;Stats
	Field hp
	Field strength
	Field speed#
	Field projectile_count_max
	Field projectile_speed#
	Field projectile_damage
	Field critMultiplier#=2
	
	;Sounds
	Field swing_sound
	Field basic_hit_sound
	
	;Game State
	Field state$="NONE"
	Field crouch_state$ = "FALSE"
	Field jump_state$ = "FALSE"
	Field attacking

End Type

Type Projectile
	;Data
	Field player
	
	;Graphic
	Field graphic
	
	;Animation
	Field animation_frames
	
	;Stats
	Field speed#
	Field damage
	
	;Physical Locations
	Field x#
	Field y#
	
	;Game state
	Field toDelete=False
	
	;Sounds
	Field throw_sound
	Field impact_sound
	
End Type
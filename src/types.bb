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
	
	;Animation
	Field breathing#
	Field breathingSpeed#
	Field breathingDirection$
	Field attackAnimFrame = 0
	
	;Frame counts
	Field basic_attack_frames
	Field projectile_animation_frames
	
	;Physical Locations
	Field x#
	Field y#
	
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
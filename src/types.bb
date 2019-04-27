Type Fighter
	;Data
	Field name$
	Field display_name$
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
	Field dead
	Field cosmetic1
	Field icon
	
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
	Field invincibility_frames
	
	;Physical Locations
	Field start_x#
	Field x#
	Field start_y#
	Field y#
	Field head_x#
	Field head_y#
	Field arm_x#
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
	Field max_hp
	Field hp
	Field strength
	Field speed#
	Field projectile_count_max
	Field projectile_speed#
	Field projectile_gravity#
	Field projectile_damage
	Field knockback=0
	Field critMultiplier#=2
	Field canAttackWhileShielding$
	Field canShootWhileShielding$
	
	;Sounds
	Field swing_sound
	Field basic_hit_sound
	Field jump_sound
	Field step_sound
	Field crit_sound
	Field projectile_sound
	Field projectile_throw_sound
	Field projectile_crit_sound
	Field kill_sound
	Field death_sound
	
	;Game State
	Field state$="NONE"
	Field crouch_state$ = "FALSE"
	Field jump_state$ = "FALSE"
	Field able_to_jump_state$ = "FALSE"
	Field shield_state$ ="FALSE"
	Field movement_state$
	Field attacking
	Field wins
	
	;Quotes
	Field win_quote

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
	Field gravity#
	Field damage
	
	;Physical Locations
	Field x#
	Field y#
	
	;Game state
	Field toDelete=False
	
	;Sounds
	Field throw_sound
	Field impact_sound
	Field crit_sound
	
End Type

Type char_select
	Field char
	Field char_gfx
	Field x
	Field y
End Type

Type Stage
	Field x#
	Field y#
	Field base_height#
	Field floor_mod#
	Field speed#
	Field gfx
End Type

Type menu_rect
	Field x
	Field y
	Field speed
End Type
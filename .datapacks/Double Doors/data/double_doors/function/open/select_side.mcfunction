execute if block ~ ~ ~ #minecraft:wooden_doors[facing=west,hinge=right] if block ~ ~ ~1 #minecraft:wooden_doors[facing=west,hinge=left] run summon marker ~ ~ ~1 {Tags:["temp_door_slect"]}
execute if block ~ ~ ~ #minecraft:wooden_doors[facing=west,hinge=left] if block ~ ~ ~-1 #minecraft:wooden_doors[facing=west,hinge=right] run summon marker ~ ~ ~-1 {Tags:["temp_door_slect"]}

execute if block ~ ~ ~ #minecraft:wooden_doors[facing=north,hinge=right] if block ~-1 ~ ~ #minecraft:wooden_doors[facing=north,hinge=left] run summon marker ~-1 ~ ~ {Tags:["temp_door_slect"]}
execute if block ~ ~ ~ #minecraft:wooden_doors[facing=north,hinge=left] if block ~1 ~ ~ #minecraft:wooden_doors[facing=north,hinge=right] run summon marker ~1 ~ ~ {Tags:["temp_door_slect"]}

execute if block ~ ~ ~ #minecraft:wooden_doors[facing=east,hinge=right] if block ~ ~ ~-1 #minecraft:wooden_doors[facing=east,hinge=left] run summon marker ~ ~ ~-1 {Tags:["temp_door_slect"]}
execute if block ~ ~ ~ #minecraft:wooden_doors[facing=east,hinge=left] if block ~ ~ ~1 #minecraft:wooden_doors[facing=east,hinge=right] run summon marker ~ ~ ~1 {Tags:["temp_door_slect"]}

execute if block ~ ~ ~ #minecraft:wooden_doors[facing=south,hinge=right] if block ~1 ~ ~ #minecraft:wooden_doors[facing=south,hinge=left] run summon marker ~1 ~ ~ {Tags:["temp_door_slect"]}
execute if block ~ ~ ~ #minecraft:wooden_doors[facing=south,hinge=left] if block ~-1 ~ ~ #minecraft:wooden_doors[facing=south,hinge=right] run summon marker ~-1 ~ ~ {Tags:["temp_door_slect"]}

execute if block ~ ~ ~ #minecraft:wooden_doors[open=true] run scoreboard players set open_stat silva_door_var 1
execute unless block ~ ~ ~ #minecraft:wooden_doors[open=true] run scoreboard players set open_stat silva_door_var 0
execute as @e[type=marker,tag=temp_door_slect,limit=1] at @s run function double_doors:open/set_second_door

kill @e[type=item,distance=..2]
execute positioned 0 5 1 run kill @e[type=item,distance=..2]
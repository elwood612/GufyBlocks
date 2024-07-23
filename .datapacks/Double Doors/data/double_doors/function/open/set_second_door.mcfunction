execute if block ~ ~ ~ #minecraft:wooden_doors[open=true] run scoreboard players set open_stat_2 silva_door_var 1
execute unless block ~ ~ ~ #minecraft:wooden_doors[open=true] run scoreboard players set open_stat_2 silva_door_var 0

clone ~ ~ ~ ~ ~1 ~ 0 4 1

execute if score open_stat silva_door_var matches 1 if score open_stat_2 silva_door_var matches 0 run function double_doors:open/action/open
execute if score open_stat silva_door_var matches 0 if score open_stat_2 silva_door_var matches 1 run function double_doors:open/action/close

fill 0 4 1 1 5 1 air

kill @s
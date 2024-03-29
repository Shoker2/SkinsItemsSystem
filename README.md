# SkinsItemsSystem

## Информация

Minecraft 1.20

Вспомогательный плагины: [PlaceholderAPI](https://github.com/PlaceholderAPI/PlaceholderAPI)

Плагин нужен для автоматического изменения скинов на предметах у игроков.

## Команды

### Установить название предмета

Варианты команды: ```/setitemname```

Разрешение: ```skinsitemssystem.setitemname```

Использование: ```/setitemname <Предмет> <Изменяемость>```

Описание: Устанавливает название предмета для скинов. Парметр "изменяемость" принимает значения 1 или 0. 1 - скин будет меняться для каждого игрока. Если 0 - установится скин для первого игрока и больше не будет меняться.

### Изменить скин предмета для игрока

Варианты команды: ```/setitemskin```, ```/setskin```

Разрешение: ```skinsitemssystem.setskin```

Использование: ```/setitemskin <Игрок> <Предмет> <Название скина>```

Описание: Устанавливает скин предмета, для игрока. Нужно для меню, в котором игрок может выбирать скин.

### Добавить скин предмета игроку

Варианты команды: ```/addavailableskin```

Разрешение: ```skinsitemssystem.addavailableskin```

Использование: ```/addavailableskin <Игрок> <Предмет> <Название скина>```

Описание: Делает скин доступным для игрока.

### Удалить скин предмета игроку

Варианты команды: ```/removeavailableskin```

Разрешение: ```skinsitemssystem.removeavailableskin```

Использование: ```/removeavailableskin <Игрок> <Предмет> <Название скина>```

Описание: Делает скин недоступным для игрока.

### Обновить все скины предметов

Варианты команды: ```/refreshskinsinventories```

Разрешение: ```skinsitemssystem.refreshskinsinventories```

Использование: ```/refreshskinsinventories```

Описание: Обновляет скины для всех игроков

### Перезагрузка

Варианты команды: ```/sisreload```

Разрешение: ```skinsitemssystem.sisreload```

Использование: ```/sisreload```

Описание: Перезагружает конфиг плагина

## Конфиг

```yml
Messages:
  NotAvailableSkins: "&fВы не можете выбрать этот облик"

# Статусы доступности скинов для PlaceholderAPI
StatusAvailableSkin:
  Selected: "&aВыбран"
  Available: "&eВыбрать"
  NotAvailable: "&cНе получен"

# Предметы
Items:
  Iron_Sword:
    # Скины в формате: <Название скина>: <ID кастомного скина (CustomModelData)>
    default: 0
    fire_gun: 1

  Diamond_Sword:
    default: 0
    test_skin: 1
```
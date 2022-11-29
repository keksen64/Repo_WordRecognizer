## Что это?
Это мое бэкэнд приложение, которое умеет распознавать слова и основные темы затронутые в тексте.
Предназначено в первую очередь для анализа новостных лент и извлечения основных тем и общего новостного фона.
Состоит из:
- асинхронного веб сервера отдающего результат работы
- обработчиков, которые извлекают различные связки слов из текста и сличают их
- шедуллера который управляет обработчиками



## Лицензия

Этот проект лицензируется в соответствии с лицензией Apache 2.0


## Попробовать
Фронт приложения развернут по адресу http://194.32.248.200:8003/main#

## Автор
Павлов Захарий

## Контакты для связи
Telegram [@kekss_pekss](https://t.me/kekss_pekss)



## Сборка и запуск

запустить проект можно из idea после клонирования к себе, либо запустить скомпилированный jar file. В файле siteList находится список сайтов, которые будет анализировать программа. 
В файле blaskList находится список слов, которые необходимо исключить из выборки. Эти два файла должны находиться в одной директории с приложением.

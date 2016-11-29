# DayNightDemo
夜间模式和日间模式的切换


####日夜间模式在app上面的体验不必多说，特别是晚上，所以这玩意儿是个好东西，民间版本的夜间模式实现效果都很友好，但是都很复杂。官方在Android Support Library 23.2开始支持了夜间模式切换，所以大家伙儿不妨试试？

***


1.切换主题的activity必须继承自AppCompatActivity

2.使用的主题，把Theme.AppCompat.DayNight作为parent：


3.新建value-night文件夹，在此文件夹中准备另一套colors和styles。里面的名字跟对应的value下名字相同，只是值不同，这样系统就会自动获取对应的值了

4.代码部分,想要切换的地方调用：


 `getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);//切换夜间模式 

  recreate();//重新启动当前activit
 `
 `getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);//切换日间模

  recreate();//重新启动当前activit
 `
5.setLocalNightMode的值的说明


  `MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式`

  `MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式`
 
  `MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题`
 
  `MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为MODE_NIGHT_NO `

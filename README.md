# AndroidBackgroundTaskSample
show some implements sample for background task in Android

# Reference
The Evolution of Android Network Access<br>
https://medium.com/@elye.project/the-evolution-of-android-network-access-1e199fc6e9a2

此專案是參考上述連結文章而寫<br>
Network Access 也是一種 background task <br>
因為需要花費許多時間  所以必須擺在背景執行  等執行完取得資料才更新 UI<br>

該文章裡提到的方法基本上對所有需要花費許多時間的動作都適用<br>
例如  讀取檔案/資料庫/計算大量數據 ..等<br>

# Memory Leak
有些方法會產生 memory leak <br>
例如 Thread / AsyncTask / RxJava 當還在背景執行時 <br>
退出 Activity , 仍會繼續執行 , 此時他會有一份 Activity 的 reference<br>
導致 Activity 無法被 gc<br>

使用了 LeakCanary 和 log 來確認的確有 leak  (sleep time 需設長一點才會測出有 leak)  <br>
(LeakCanary 目前的版本似乎有點問題 , 產生一次 leak 之後 <br>
再有 leak 就會出現 "Could not dump heap, previous analysis still is in progress" 的警告<br>

解決 Memory Leak 的方法網路上有許多文章可參考 <br>
大致上是使用 static / weak reference / 在 onDestroy 時 cancel 等等   <br>

# 1. xaml
  * 定义属性的两种方式
    ```xml
    <!-- 第一种方式 -->
    <Grid Name="grid1">
    </Grid>

    <!-- 第二种方式 -->
    <Grid>
        <Grid.Name>grid1</Grid.Name>
    </Grid>
    ```
  * 附加属性
    ```xml
    <!-- Grid.Row为附加属性 -->
    <Button Content="Button3" HorizontalAlignment="Left" Margin="315,57,0,0" Grid.Row="2" VerticalAlignment="Top" Width="75"/>
    ```
  * xml:space
    ```xml
    <!-- xml:space="preserve"可以让标签体中内容的空格显示 -->
    <TextBox HorizontalAlignment="Left" Height="59" Margin="109,54,0,0" TextWrapping="Wrap" VerticalAlignment="Top" Width="142" xml:space="preserve">
            this is a aaa        bbb
    </TextBox>
    ```

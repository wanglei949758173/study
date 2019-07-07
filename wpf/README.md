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
# 2. wpf布局
  * StackPanel <br>
    StackPanel主要是控制元素的排列方式(水平排列/垂直排列)
    ```xml
    <!-- 默认垂直排列, 设置Orientation="Horizontal"水平排列-->
    <StackPanel Name="stackPanel1" Orientation="Horizontal">
        <Label Name="label1" Content="Label" Height="28"/>
        <!--HorizontalAlignment="Left"设置水平对齐属性-->
        <Button Name="Button1" Content="Button1" HorizontalAlignment="Left"/>
        <!--VerticalAlignment="Center"设置垂直方向对齐属性-->
        <Button Name="Button3" Content="Button3" VerticalAlignment="Center"/>
        <!--Margin MinWidth MaxWidth-->
        <Button Name="Button4" Content="Button4" Margin="10,10,10,10"
            MinWidth="20" MaxWidth="40"/>
        <Button Name="Button5" Content="Button5"/>
    </StackPanel>
    ```
  * WarpPanel <br>
  * DockPanel <br>
  * Grid
    设置width="*" Width="2*"
    <Button Grid.ColumnSpan="2" />占用两列
    <!-- 分隔线 -->
    <GridSplitter Grid.Column="1" Width="3" Grid.RowSpan="2"
                      HorizontalAlignment="Center"
                      VerticalAlignment="Stretch"/>

    SharedSizeGroup
  * Canvas
# 3. 路由事件
  * 路由事件的三种方式
    + 直接路由事件
    + 冒泡路由事件
      事件由下级元素向上级元素传递
      + RoutedEventArgs e
        source: 事件源
        e.Handled = true;让路由事件不再向上传递
    + 隧道路由事件
      事件由上级元素向下级元素传递 preview

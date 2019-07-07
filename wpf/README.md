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
    **StackPanel**主要是控制容器内元素的排列方式(水平排列/垂直排列)
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
    **WarpPanel**是一种行级容器，在想创建一行时来使用**WarpPanel**容器
    ```xml
    <!--WarpPanel表示一行,一行的高度有容器里最高的元素的高度决定-->
    <WrapPanel Name="warpPanel1">
        <Button Name="Button1" Content="Button1" Height="23" Width="75" />
        <Button Name="Button2" Content="Button2" Height="132" Width="75" />
        <Button Name="Button3" Content="Button3" Height="23" Width="75" />
        <Button Name="Button4" Content="Button4" Height="23" Width="75" />
    </WrapPanel>
    ```
  * DockPanel <br>
    **DockPanel**名为浮动容器，可以用来对页面进行布局
    ```xml
     <!-- LastChildFill="True" 让最后一个子元素填满剩余的区域-->
     <DockPanel Name="dockPanel1" LastChildFill="True">
        <!-- 元素的放置顺序会改变布局 -->
        <Button Content="Top Button" DockPanel.Dock="Top" Name="button1" Height="35" />
        <Button Content="Bottom Button" DockPanel.Dock="Bottom" Name="button3" Height="25" />
        <Button Content="Left Button" DockPanel.Dock="Left" Name="button2" Width="150"/>
        <Button Content="Rigth Button" DockPanel.Dock="Right" Name="button5" Width="100"/>
        <Button Content="Remaining Space" Name="button4"  />
    </DockPanel>
    ```
  * Grid <br>
    + **Grid**可以将页面布局成为表格形式的布局,使用时可以定义行和列
    ```xml
    <Grid ShowGridLines="False" UseLayoutRounding="True">
        <Grid.RowDefinitions>
            <RowDefinition></RowDefinition>
            <RowDefinition></RowDefinition>
        </Grid.RowDefinitions>
        <Grid.ColumnDefinitions>
            <!-- 设置Width="*" Width="2*" 可以让一列的宽为另一列的二倍 -->
            <ColumnDefinition Width="*" MinWidth="50"></ColumnDefinition>
            <ColumnDefinition Width="Auto"></ColumnDefinition>
            <ColumnDefinition Width="2*" MinWidth="50"></ColumnDefinition>
            <ColumnDefinition Width="3*"></ColumnDefinition>
        </Grid.ColumnDefinitions>
        <Button Margin="10" Content="LeftTop" Grid.Row="0" Grid.Column="0" />
        <Button Margin="10" Content="CenterTop" Grid.Row="0" Grid.Column="3" />
        <Button Margin="10" Content="RightTop" Grid.Row="0" Grid.Column="2" />
        <Button Margin="10" Content="LeftBottom" Grid.Row="1" Grid.Column="0" />
        <Button Margin="10" Content="CenterBottom" Grid.Row="1" Grid.Column="2" />
        <Button Margin="10" Content="RightBottom" Grid.Row="1" Grid.Column="3" />
        <!-- RowSpan 和 ColSpan 可以指定元素占用多行或多列 -->
        <!-- GridSplitter为分割线,可以左右拖动 -->
        <GridSplitter Grid.Column="1" Width="3" Grid.RowSpan="2"
                      HorizontalAlignment="Center"
                      VerticalAlignment="Stretch"/>
    </Grid>
    ```
    + 共享尺寸组`SharedSizeGroup="Text"`<br>
      设置共享尺寸组可以使**位于不同Grid的两个列的宽度保持一致**。设置共享尺寸组的步骤如下：
        + 将两个Grid放入一个父容器中，并设置父容器Grid.IsSharedSizeScope="True"
        + 为需要保持宽度一致的列添加SharedSizeGroup="xxx"
        ```xml
        <Grid Grid.IsSharedSizeScope="True">
            <Grid.RowDefinitions>
                <RowDefinition />
                <RowDefinition />
            </Grid.RowDefinitions>
            <Grid ShowGridLines="False" UseLayoutRounding="True" Grid.Row="0" >
                <Grid.RowDefinitions>
                    <RowDefinition></RowDefinition>
                    <RowDefinition></RowDefinition>
                </Grid.RowDefinitions>
                <Grid.ColumnDefinitions>
                    <!-- 设置Width="*" Width="2*" 可以让一列的宽为另一列的二倍 -->
                    <ColumnDefinition Width="*" MinWidth="50"></ColumnDefinition>
                    <ColumnDefinition Width="Auto"></ColumnDefinition>
                    <ColumnDefinition Width="2*" MinWidth="50"></ColumnDefinition>
                    <ColumnDefinition Width="3*"></ColumnDefinition>
                    <ColumnDefinition Width="Auto" SharedSizeGroup="Text" />
                </Grid.ColumnDefinitions>
                <Button Margin="10" Content="LeftTop" Grid.Row="0" Grid.Column="0" />
                <Button Margin="10" Content="CenterTop" Grid.Row="0" Grid.Column="3" />
                <Button Margin="10" Content="RightTop" Grid.Row="0" Grid.Column="2" />
                <Button Margin="10" Content="LeftBottom" Grid.Row="1" Grid.Column="0" />
                <Button Margin="10" Content="CenterBottom" Grid.Row="1" Grid.Column="2" />
                <Button Margin="10" Content="RightBottom" Grid.Row="1" Grid.Column="3" />
                <!-- RowSpan 和 ColSpan 可以指定元素占用多行或多列 -->
                <!-- GridSplitter为分割线,可以左右拖动 -->
                <GridSplitter Grid.Column="1" Width="3" Grid.RowSpan="2"
                          HorizontalAlignment="Center"
                          VerticalAlignment="Stretch"/>
                <Label Content="我的宽度很宽，你和我保持一样" Grid.Row="0" Grid.Column="4" />
            </Grid>

            <Grid Grid.Row="1">
                <Grid.RowDefinitions>
                    <RowDefinition />
                </Grid.RowDefinitions>
                <Grid.ColumnDefinitions>
                    <ColumnDefinition Width="Auto" SharedSizeGroup="Text" />
                    <ColumnDefinition />
                </Grid.ColumnDefinitions>
                <Label Content="我的宽度很窄" />
            </Grid>
        </Grid>
        ```
  * Canvas <br>
    **Canvas**表示画布,可以在画布上使用定位的方式来为页面进行布局
    ```xml
    <Canvas Name="canvas1">
        <!--Canvas.Left Canvas.Right Canvas.Top Canvas.Bottom 表示距离Canvas的
        左右、上下的距离,相当于绝对定位一样-->
        <Button Content="Button" Canvas.Left="380" Canvas.Top="86" Width="75" Click="Button_Click"/>
        <!--默认会被DataGrid控键遮住,设置Canvas.ZIndex="1"显示-->
        <Button Content="Button" Canvas.ZIndex="1"  Canvas.Left="162" Canvas.Top="237" Width="75" RenderTransformOrigin="-2.639,-0.003"/>
        <DataGrid Height="158" Canvas.Left="147" Canvas.Top="178" Width="260"/>
    </Canvas>
    ```
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
# 4. 事件
  * 键盘输入
    ```
    // 键盘输入依次触发的事件如下
    PreviewKeyDown

    ```

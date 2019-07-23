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
    KeyDown
    previewTextInput
    TextInput
    previewKeyUp
    KeyUp
    ```

# 5. 控件类
  * 设置字体更加清晰
  ```xml
  <!-- 通过设置附加属性TextOptions.TextFormattingMode="Display"来调整文本的清晰度 -->
  <TextBox FontSize="12">这一行文本清晰度普通</TextBox>
  <TextBox FontSize="12" TextOptions.TextFormattingMode="Display">这一行文本更加清晰</TextBox>
  ```
  * Target(Target可以绑定另一个控件)
     ```xml
     <!-- 测试Target属性 _A表示按A键光标直接转到textBox1 -->
    <StackPanel Name="stackPanel1">
        <Label Name="label1" Target="{Binding ElementName=textBox1}" Margin="5">按下 _A</Label>
        <TextBox Name="textBox1" Margin="5" />
    </StackPanel>
     ```
  * Button(`IsCanel`属性和`IsDefault`属性)
    ```xml
    <!-- 设置IsCancel="True"默认点击ESC键时触发该按钮点击事件 -->
    <Button IsCancel="True" Margin="10" Height="40" Click="Button_Click">canelBtn</Button>
    <!-- 设置IsDefault="True"默认点击回车时触发该按钮点击事件 -->
    <Button IsDefault="True" Margin="10" Height="40" Click="Button_Click_1">defaultBtn</Button>
    ```
  * ToolTip
    ```xml
    <!-- 给按钮设置提示信息 -->
    <Button Height="30" Margin="30"  Content="按钮">
        <Button.ToolTip>
            <ToolTip Background="AliceBlue">
                <StackPanel>
                    <TextBlock>THIS IS A Button</TextBlock>
                </StackPanel>
            </ToolTip>
        </Button.ToolTip>
    </Button>
    ```
  * RadioButton
    ```xml
    <!-- 放在同一容器下，默认是一组,如果放在不同容器下，可以使用GroupName=""属性标识单选按钮为一组 -->
    <WrapPanel Margin="50,100,50,50">
        <RadioButton Content="学习" />
        <RadioButton Content="打游戏" />
    </WrapPanel>
    ```
  * CheckBox
    ```xml
    <WrapPanel Orientation="Horizontal" Margin="50" Height="60" VerticalAlignment="Top">
        <CheckBox Content="乒乓球" HorizontalAlignment="Left" />
        <CheckBox Content="篮球" HorizontalAlignment="Left"  />
        <CheckBox Content="足球" HorizontalAlignment="Left"  />
    </WrapPanel>
    ```
  * Popup
    ```xml
    <StackPanel Margin="20">
        <TextBlock TextWrapping="Wrap">
            测试使用Popup，再说一些废话加长以下看看,换行就行。
            <Run TextDecorations="Underline" MouseEnter="Run_MouseEnter">点我</Run>
        </TextBlock>
        <Popup Name="popLink" StaysOpen="False" Placement="Mouse" MaxWidth="200"
               PopupAnimation="Slide" AllowsTransparency="True">
            <Border BorderBrush="Beige" BorderThickness="2" Background="White">
                <TextBlock Margin="10" TextWrapping="Wrap">
                    查看更多信息,请看
                    <Hyperlink NavigateUri="http://www.baidu.com" Click="Hyperlink_Click">百度</Hyperlink>
                </TextBlock>
            </Border>
        </Popup>
    </StackPanel>
    ```
    ```csharp
    private void Run_MouseEnter(object sender, MouseEventArgs e)
    {
        // 显示Popup，设置IsOpen属性为true
        this.popLink.IsOpen = true;
    }

    private void Hyperlink_Click(object sender, RoutedEventArgs e)
    {
        Process.Start(((Hyperlink)sender).NavigateUri.ToString());
    }
    ```
  * ScrollViewer
    ```xml
    <!-- 一个可以滚动的容器组件 -->
    <ScrollViewer Name="ScrollViewer1" Margin="3"
                  VerticalScrollBarVisibility="Auto">
        <TextBox TextWrapping="Wrap">
            清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。
            清华大学的前身清华学堂始建于1911年，校名“清华”源于校址“清华园”地名，是清政府设立的留美预备学校，其建校的资金源于1908年美国退还的部分庚子赔款。1912年更名为清华学校。1928年更名为国立清华大学。1937年抗日战争全面爆发后南迁长沙，与国立北京大学、私立南开大学组建国立长沙临时大学，1938年迁至昆明改名为国立西南联合大学。1946年迁回清华园。1949年中华人民共和国成立，清华大学进入新的发展阶段。1952年全国高等学校院系调整后成为多科性工业大学。1978年以来逐步恢复和发展为综合性的研究型大学。
            水木清华，钟灵毓秀，清华大学秉持“自强不息、厚德载物”的校训和“行胜于言”的校风，坚持“中西融汇、古今贯通、文理渗透”的办学风格和“又红又专、全面发展”的培养特色，弘扬“爱国奉献、追求卓越”传统和“人文日新”精神。恰如清华园工字厅内对联所书——“槛外山光，历春夏秋冬、万千变幻，都非凡境；窗中云影，任东西南北、去来澹荡，洵是仙居”。
        </TextBox>
    </ScrollViewer>
    ```
    ```xml
    <!-- 设置CanContentScroll="True"可以一次滚动一个元素 -->
    <ScrollViewer Name="ScrollViewer1" Margin="3"
                  VerticalScrollBarVisibility="Auto"
                  CanContentScroll="True">
        <StackPanel Margin="2">
            <Button Content="Button1" Height="100" Width="75" Margin="1" />
            <Button Content="Button2" Height="100" Width="75" Margin="1" />
            <Button Content="Button3" Height="100" Width="75" Margin="1" />
            <Button Content="Button4" Height="100" Width="75" Margin="1" />
            <Button Content="Button5" Height="100" Width="75" Margin="1" />
        </StackPanel>
    </ScrollViewer>
    ```
  * GroupBox
    ```xml
    <GroupBox Header="填写爱好信息" Margin="3">
        <StackPanel>
            <RadioButton Content="乒乓球" Margin="3" Height="16" />
            <RadioButton Content="羽毛球" Margin="3" Height="16" />
            <RadioButton Content="篮球" Margin="3" Height="16" />
            <Button Content="下一步" Height="30" Margin="3" />
        </StackPanel>
    </GroupBox>
    ```
  * TabControl
    ```xml
    <TabControl Name="tabControl1" Margin="3" >
        <TabItem>
            <TabItem.Header>
                <TextBlock>添加用户</TextBlock>
            </TabItem.Header>
            <StackPanel Margin="10">
                <TextBox Text="username" Margin="10"/>
                <TextBox Text="password" Margin="10"/>
                <TextBox Text="age" Margin="10"/>
                <Button Margin="10" Content="添加" />
            </StackPanel>
        </TabItem>
        <TabItem>
            <TabItem.Header>
                <TextBlock>用户列表</TextBlock>
            </TabItem.Header>
            <StackPanel Margin="10">
            </StackPanel>
        </TabItem>
    </TabControl>
    ```
  * Expander
    ```xml
    <StackPanel>
        <Expander Header="清华大学" Margin="5" Padding="5" >
            <TextBlock TextWrapping="Wrap">
                清华大学（Tsinghua University），简称“清华”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、亚洲大学联盟、环太平洋大学联盟、清华—剑桥—MIT低碳大学联盟成员，被誉为“红色工程师的摇篮”。
                清华大学的前身清华学堂始建于1911年，校名“清华”源于校址“清华园”地名，是清政府设立的留美预备学校，其建校的资金源于1908年美国退还的部分庚子赔款。1912年更名为清华学校。1928年更名为国立清华大学。1937年抗日战争全面爆发后南迁长沙，与国立北京大学、私立南开大学组建国立长沙临时大学，1938年迁至昆明改名为国立西南联合大学。1946年迁回清华园。1949年中华人民共和国成立，清华大学进入新的发展阶段。1952年全国高等学校院系调整后成为多科性工业大学。1978年以来逐步恢复和发展为综合性的研究型大学。
                水木清华，钟灵毓秀，清华大学秉持“自强不息、厚德载物”的校训和“行胜于言”的校风，坚持“中西融汇、古今贯通、文理渗透”的办学风格和“又红又专、全面发展”的培养特色，弘扬“爱国奉献、追求卓越”传统和“人文日新”精神。恰如清华园工字厅内对联所书——“槛外山光，历春夏秋冬、万千变幻，都非凡境；窗中云影，任东西南北、去来澹荡，洵是仙居”。
            </TextBlock>
        </Expander>
        <Expander Header="北京大学" Margin="5" Padding="5" IsExpanded="True">
            <TextBlock TextWrapping="Wrap">
                北京大学（Peking University），简称“北大”，由中华人民共和国教育部直属，中央直管副部级建制，位列“211工程”、“985工程”、“世界一流大学和一流学科”，入选“基础学科拔尖学生培养试验计划”、“高等学校创新能力提升计划”、“高等学校学科创新引智计划”，为九校联盟、中国大学校长联谊会、京港大学联盟、亚洲大学联盟、东亚研究型大学协会、国际研究型大学联盟、环太平洋大学联盟、东亚四大学论坛、国际公立大学论坛、中俄综合性大学联盟成员。
                北京大学创立于1898年维新变法之际，初名京师大学堂，是中国近现代第一所国立综合性大学，创办之初也是国家最高教育行政机关。1912年改为国立北京大学。1937年南迁至长沙，与国立清华大学和私立南开大学组成国立长沙临时大学，1938年迁至昆明，更名为国立西南联合大学。1946年复员返回北平。1952年经全国高校院系调整，成为以文理基础学科为主的综合性大学，并自北京城内沙滩等地迁至现址。2000年与原北京医科大学合并，组建为新的北京大学。
                北京大学是新文化运动的中心和五四运动的策源地，最早在中国传播马克思主义和科学、民主思想，是创建中国共产党的重要基地之一。长期以来，北京大学始终与中国和中国人民共命运，与时代和社会同前进，是培养和造就高素质创造性人才的摇篮，恰如蔡元培先生所言：“大学者，囊括大典，网罗众家之学府也……此思想自由之通则，而大学之所以为大也。”
            </TextBlock>
        </Expander>
    </StackPanel>
    ```
  * TextBox
  * PasswordBox
  * ListBox
    ```xml
    <ListBox Height="Auto" Margin="5" Name="listBox1">
        <StackPanel>
            <TextBlock>中国</TextBlock>
        </StackPanel>
        <StackPanel>
            <TextBlock>美国</TextBlock>
        </StackPanel>
        <StackPanel>
            <TextBlock>英国</TextBlock>
        </StackPanel>
    </ListBox>
    ```
  * ComboBox
  * Slider
    ```xml
    <Slider Maximum="100" Minimum="0" Value="10" Ticks="10,30,60" TickPlacement="BottomRight" />
    ```
  * ProgressBar
    ```xml
    <ProgressBar Maximum="100" Minimum="0" Height="20" Margin="10" IsIndeterminate="True" />
    ```
  * Calendar
    ```xml
    <!-- DisplayDateStart和DisplayDateEnd属性可以指定可以选择的开始时间和结束时间 -->
    <Calendar SelectionMode="SingleDate"  DisplayDateStart="2019-07-01" DisplayDateEnd="2019-07-09"/>
    ```
  * DatePicker
    ```xml
    <!-- IsDropDownOpen属性可以让日历默认展开 -->
    <DatePicker Margin="20" Width="200" IsDropDownOpen="True" />
    ```

# 6. Application
  ```xml
  <Application.Resources>
      <!--通过ShutdownMode="OnLastWindowClose"属性设置程序的关闭模式-->
  </Application.Resources>
  ```
  ```csharp
  protected override void OnStartup(StartupEventArgs e)
  {
      // 通过回调事件OnXXX来干自己想干的事
      base.OnStartup(e);
      MainWindow window = new MainWindow();

      if(e.Args.Length > 0)
      {
          string file = e.Args[0];
          if (File.Exists(file))
          {
              window.LoadFile(file);
          }
      }
      window.Show();
  }
  ```
  * 创建一个单实例的wpf程序
    ```csharp
    // 先添加 Microsoft.VisualBasic的动态链接库
    class SingleInstanceApplicationWrapper : WindowsFormsApplicationBase
    {
        public SingleInstanceApplicationWrapper()
        {
            // 设置单实例属性为true
            this.IsSingleInstance = true;
        }

        private WpfApp app;

        protected override bool OnStartup(StartupEventArgs eventArgs)
        {
            base.OnStartup(eventArgs);
            app = new WpfApp();
            app.Run();
            return false;
        }

        protected override void OnStartupNextInstance(StartupNextInstanceEventArgs eventArgs)
        {
            base.OnStartupNextInstance(eventArgs);
            app.ShowWindow();
        }
    }
    ```

# 7. 资源
  * Resource <br>
    打包时会直接嵌入到exe中
  * 内容文件 <br>
    输出到程序目录下

# 8. 绑定

## 8.1 绑定到元素对象
  * 绑定表达式
    ```xml
    <Slider Name="Slider1" Height="Auto"  Margin="10" Minimum="15" Maximum="40" Value="20"
                TickPlacement="TopLeft" TickFrequency="1" IsSnapToTickEnabled="True"/>

    <!-- 目标对象 -->
    <TextBlock Name="textblock1" Text="simple Text" Margin="10"
               FontSize="{Binding ElementName=Slider1,Path=Value,Mode=TwoWay}"/>
    ```
  * 绑定模式
    + TwoWay <br>
      导致更改源属性或目标属性时自动更新另一方
    + OneWay <br>
      在更改绑定源（源）时更新绑定目标（目标）
    + OneTime <br>
       在应用程序启动或数据上下文更改时，更新绑定目标
    + OneWayToSource <br>
      在目标属性更改时，更新源属性
    + OneWayToSource <br>
      每个依赖属性的默认值都不同
  * 使用代码创建绑定
    ```csharp
     private void Window_Loaded(object sender, RoutedEventArgs e)
      {
          Binding binding = new Binding();
          // 设置绑定的源对象为slider1
          binding.Source = this.Slider1;
          binding.Path = new PropertyPath("Value");
          binding.Mode = BindingMode.TwoWay;

          // 设置目标对象textblock1的FontSize属性绑定到独享binding上
          this.textblock1.SetBinding(TextBlock.FontSizeProperty, binding);
      }
    ```
  * 绑定更新
    ```xml
    <!-- UpdateSourceTrigger=PropertyChanged -->
    <TextBox Text="{Binding ElementName=textblock1,Path=FontSize,Mode=TwoWay,UpdateSourceTrigger=PropertyChanged}" Margin="10" Name="textBox1" />
    ```
  * 取消绑定
    ```csharp
    private void Button_Click(object sender, RoutedEventArgs e)
    {
        BindingOperations.ClearAllBindings(this.textblock1);
    }
    ```
  *

## 8.2 绑定到非元素对象
  * Source属性
    ```xml
    <Window.Resources>
        <FontFamily x:Key="CustomFont">我的字体</FontFamily>
    </Window.Resources>
    <Grid>
        <StackPanel Margin="10">
            <!--绑定到系统字体家族对象上-->
            <TextBlock Margin="10" Text="{Binding Source={x:Static SystemFonts.IconFontFamily}, Path=Source}" />

            <!--绑定到资源上-->
            <TextBlock Margin="10" Text="{Binding Source={StaticResource CustomFont}, Path=Source}" />
        </StackPanel>
    </Grid>
    ```
  * RelativeSource属性
    ```xml
    <Grid>
        <StackPanel Margin="10">
            <!-- 绑定到window的窗口上 -->
            <TextBlock Margin="10">
                <TextBlock.Text>
                    <Binding Path="Title">
                        <Binding.RelativeSource>
                            <RelativeSource Mode="FindAncestor" AncestorType="{x:Type Window}" />
                        </Binding.RelativeSource>
                    </Binding>
                </TextBlock.Text>
            </TextBlock>

            <!-- 更简洁的使用RelativeSource属性 -->
            <TextBlock Margin="10" Text="{Binding Path=Title,RelativeSource={RelativeSource Mode=FindAncestor,AncestorType=Window}}" />
        </StackPanel>
    </Grid>
    ```
  * DataContext属性
    ```xml
    <StackPanel Margin="10" DataContext="{x:Static SystemFonts.IconFontFamily}">
        <!-- 相当于{Binding Source={x:Static SystemFonts.IconFontFamily}, Path=Source} -->
        <TextBlock Text="{Binding Path=Source}" Margin="10" />
        <!-- 相当于{Binding Source={x:Static SystemFonts.IconFontFamily}, Path=LineSpacing} -->
        <TextBlock Text="{Binding Path=LineSpacing}" Margin="10" />
        <!-- 相当于{Binding Source={x:Static SystemFonts.IconFontFamily}, Path=FamilyTypefaces[0].Style} -->
        <TextBlock Text="{Binding Path=FamilyTypefaces[0].Style}" Margin="10" />
    </StackPanel>
    ```

# 9. 资源
  * WPF资源
    ```xml
    <!-- 定义资源 -->
    <Window.Resources>
        <ImageBrush x:Key="TileBrush" TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" ImageSource="image/timg.jpg" />
    </Window.Resources>
    <StackPanel Margin="10">
        <!-- 使用资源 -->
        <Button Margin="10" Background="{StaticResource ResourceKey=TileBrush}" Content="Button" Padding="5" FontSize="14"/>
        <Button Margin="10" Content="Button" Padding="5" FontSize="14"/>
        <Button Margin="10" Content="Button" Padding="5" FontSize="14"/>
    </StackPanel>
    ```
  * 资源层次
    + 控件可以使用父元素的资源
    + 一个元素下的资源的`x:key`不能重复
    + 控件寻找资源会由下至上找,直到找到就不再向上继续寻找
  * 静态资源和动态资源
    ```xml
    <StackPanel Name="stackPanel1" Margin="10">
        <StackPanel.Resources>
            <ImageBrush x:Key="TileBrush" TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" ImageSource="image/timg.jpg" />
        </StackPanel.Resources>
        <!-- 静态资源当资源改变时其不变 -->
        <Button Margin="10" Background="{StaticResource ResourceKey=TileBrush}" Content="Button" Padding="5" FontSize="14"/>
        <Button Margin="10" Content="改变资源" Padding="5" FontSize="14" Click="Button_Click"/>
        <!-- 动态资源随着资源的改变而改变 -->
        <Button Margin="10" Background="{DynamicResource ResourceKey=TileBrush}" Content="Button" Padding="5" FontSize="14"/>
    </StackPanel>
    ```
  * 通过代码访问资源
    ```csharp
    private void Button_Click(object sender, RoutedEventArgs e)
    {
        this.stackPanel1.Resources["TileBrush"] = new SolidColorBrush(Colors.LightBlue);
    }
    ```
  * 应用程序资源
    + 资源由下至上寻找，找到Window并未结束,还会寻找App.xaml中的Application.Resources
      ```xml
      <Application.Resources>
          <ImageBrush x:Key="TileBrush" TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" ImageSource="image/timg.jpg" />
      </Application.Resources>
      ```
  * 系统资源
    ```xml
    <StackPanel Name="stackPanel1" Margin="10">
        <!-- 设置系统文本画刷 -->
        <Button Margin="10" Content="Button" Foreground="{x:Static SystemColors.WindowTextBrush}" Padding="5" FontSize="14"/>

        <!--绑定为动态资源,系统属性改变后会立马改变 -->
        <Button Margin="10" Content="Button" Foreground="{DynamicResource ResourceKey={x:Static SystemColors.WindowTextBrushKey}}" Padding="5" FontSize="14"/>
    </StackPanel>
    ```

# 10. 资源字典
  * 使用资源字典
    + 创建资源字典(右键 -> 添加资源字典)
      ```xml
      <ResourceDictionary xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
                          xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml"
                          xmlns:local="clr-namespace:UseResourceDic">
          <ImageBrush x:Key="TileBrush1" TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" ImageSource="images/happy.jpg"></ImageBrush>
          <ImageBrush x:Key="TileBrush2" TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" ImageSource="images/sad.jpg"></ImageBrush>
      </ResourceDictionary>
      ```
    + App.xaml中引用资源字典
      ```xml
      <Application.Resources>
          <ResourceDictionary>
              <ResourceDictionary.MergedDictionaries>
                  <ResourceDictionary Source="Dictionary1.xaml"  />
              </ResourceDictionary.MergedDictionaries>
          </ResourceDictionary>
      </Application.Resources>
      ```
    + 使用资源字典
      ```xml
      <StackPanel Margin="10">
          <Button Margin="10" Padding="5" Content="Button" FontSize="14" Background="{StaticResource ResourceKey=TileBrush1}"/>
          <Button Margin="10" Padding="5" Content="Button" FontSize="14" Background="{DynamicResource ResourceKey=TileBrush2}"/>
      </StackPanel>
      ```
  * 程序集之间共享资源

# 11. 样式
  * 样式基本使用
    ```xml
    <!-- 定义样式 -->
    <Window.Resources>
        <Style x:Key="BigFontButtonStyle">
            <Setter Property="Control.FontFamily" Value="Times New Roman"/>
            <Setter Property="Control.FontSize" Value="18" />
            <Setter Property="Control.FontWeight" Value="Bold" />
            <Setter Property="Control.Background">
                <Setter.Value>
                    <ImageBrush TileMode="Tile" ViewportUnits="Absolute" Viewport="0 0 32 32" Opacity="0.3" ImageSource="happy.jpg"/>
                </Setter.Value>
            </Setter>
        </Style>
    </Window.Resources>
    <StackPanel Margin="10">
        <!-- 设置样式 -->
        <Button Content="Custom Button" Padding="5" Margin="5" Style="{StaticResource ResourceKey=BigFontButtonStyle}"/>
        <TextBlock  Text="Normal Content" Margin="5" Padding="5" />
        <Button Content="Normal Button" Padding="5" Margin="5" />
        <TextBlock  Text="More Normal Content" Margin="5" Padding="5" />
        <Button Content="Another Custom Button" Padding="5" Margin="5" Style="{StaticResource ResourceKey=BigFontButtonStyle}"/>
    </StackPanel>
    ```
  * 关联事件处理程序
    ```xml
    <Window.Resources>
        <!-- 定义资源 -->
        <Style x:Key="MouseOverHighLight">
            <Setter Property="TextBlock.Padding" Value="10" />
            <EventSetter Event="FrameworkElement.MouseEnter" Handler="mouseEnter" />
            <EventSetter Event="FrameworkElement.MouseLeave" Handler="mouseLeave" />
        </Style>
    </Window.Resources>
    <StackPanel Margin="10">
        <TextBlock Text="Hello, I am fine" Margin="5" Padding="5" Style="{StaticResource ResourceKey=MouseOverHighLight}"/>
        <TextBlock Text="Are you OK?" Margin="5" Padding="5" />
        <TextBlock Text="Thank You" Margin="5" Padding="5" />
    </StackPanel>
    ```
    ```csharp
    public void mouseEnter(Object sender,MouseEventArgs args)
    {
        ((TextBlock)sender).Background = new SolidColorBrush(Colors.LightGoldenrodYellow);
    }

    public void mouseLeave(Object sender, MouseEventArgs args)
    {
        ((TextBlock)sender).Background = null;
    }
    ```
  * 多层样式
    ```xml
     <!-- 使用其他样式,设置BasedOn属性-->
    <Style x:Key="HasBackgroudColorStyle" BasedOn="{StaticResource ResourceKey=BigFontButtonStyle}">
        <Setter Property="Control.Foreground" Value="White"/>
        <Setter Property="Control.Background" Value="DarkBlue"/>
        <!-- 样式重复,使用自己的 -->
        <Setter Property="Control.FontSize" Value="10" />
    </Style>
    ```
  * 通过类型自动应用样式
    ```xml
    <!-- 使用TargetType让控件自动应用样式,不想使用此样式设置控件style={x:Null} -->
    <Style x:Key="BigFontButtonStyle" TargetType="Button">
    </Style>
    ```

# 12. 触发器
  * 简单触发器
    ```xml
    <Window.Resources>
        <Style x:Key="BigFontBtn">
            <Style.Setters>
                <Setter Property="Control.FontSize" Value="18" />
                <Setter Property="Control.FontFamily" Value="Time New Roman" />
            </Style.Setters>
            <!-- 触发器 -->
            <Style.Triggers>
                <Trigger Property="Control.IsFocused" Value="True">
                    <Setter Property="Control.Foreground" Value="DarkRed" />
                </Trigger>
                <Trigger Property="Button.IsPressed" Value="True">
                    <Setter Property="Control.Foreground" Value="Yellow" />
                </Trigger>
            </Style.Triggers>
        </Style>
    </Window.Resources>
    <StackPanel Margin="10">
        <Button Height="200" Content="Button" Margin="10" Style="{StaticResource ResourceKey=BigFontBtn}"/>
    </StackPanel>
    ```
  * 多值触发器
    ```xml
    <Window.Resources>
        <Style x:Key="MultiTrigger">
            <Style.Triggers>
                <MultiTrigger>
                    <MultiTrigger.Conditions>
                        <Condition Property="Control.IsFocused" Value="True"/>
                        <Condition Property="Control.IsMouseOver" Value="True"/>
                    </MultiTrigger.Conditions>
                    <MultiTrigger.Setters>
                        <Setter Property="Control.Foreground" Value="Red" />
                    </MultiTrigger.Setters>
                </MultiTrigger>
            </Style.Triggers>
        </Style>
    </Window.Resources>
    <StackPanel>
        <Button Content="Button" Height="200" Margin="10" Style="{StaticResource ResourceKey=MultiTrigger}"/>
        <TextBox Height="50" Margin="10"/>
    </StackPanel>
    ```
  * 事件触发器
    ```xml
    <Window.Resources>
        <Style x:Key="EventTrigger">
            <Style.Triggers>
                <!-- MouseEnter时字体放大 -->
                <EventTrigger RoutedEvent="Mouse.MouseEnter">
                    <EventTrigger.Actions>
                        <BeginStoryboard>
                            <Storyboard>
                                <DoubleAnimation Duration="0:0:3" To="48" Storyboard.TargetProperty="FontSize" />
                            </Storyboard>
                        </BeginStoryboard>
                    </EventTrigger.Actions>
                </EventTrigger>
                <!-- MouseLeave时字体恢复到原来的大小 -->
                <EventTrigger RoutedEvent="Mouse.MouseLeave">
                    <EventTrigger.Actions>
                        <BeginStoryboard>
                            <Storyboard>
                                <DoubleAnimation Duration="0:0:1" Storyboard.TargetProperty="FontSize" />
                            </Storyboard>
                        </BeginStoryboard>
                    </EventTrigger.Actions>
                </EventTrigger>
            </Style.Triggers>
        </Style>
    </Window.Resources>
    <StackPanel Margin="10">
        <Button Margin="10" Content="Button" Height="200" Style="{StaticResource ResourceKey=EventTrigger}"/>
    </StackPanel>
    ```

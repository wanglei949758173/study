   M S B A M L   `   `   `  ����L  HBindingHelloWorld, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:BindingHelloWorldBindingHelloWorld  5   	   "    BindingHelloWorld.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:BindingHelloWorld     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �� $��5q�6   .+�5
   
   �� -   5        $��Slider1��5
      $
��Auto��6    $��10q�6/    � Minimum$ 15Q�6;    � Maximum$ 40Q�6H    � Value$ 20Q�6U    �� TickPlacement$ TopLeft=�5       �� TickFrequency$ 1Q�6)    �� IsSnapToTickEnabled . 6;   �� 5   
   -   5        $��
textblock1��5      $��simple Text��6&   $��10q�69   ��5      ��  �� ElementName$ Slider1�� �� Path$ Value�	 �� Mode$	 TwoWay=���5      �� $ listBox1��$ SelectedItem.Tag��� 5   
   -   5        $��取消绑定��5      $��100,10q�6    60   �� 5   
   -   5        $��listBox1��5      $��10q�6   .@�5      �� 

 � Tag$

 Blue��6   $��蓝色��6%   �� 5      $
 Green��6   $��绿色��6&   �� 5      $
 Yellow��6   $��黄色��6'   5      �� 5   
   -   5        $��textBox1��5   �   $��10q�6x   ��6   �� $ 
textblock1��$ FontSize�$	 TwoWay=� �� UpdateSourceTrigger$ PropertyChanged=�6�   5      5      
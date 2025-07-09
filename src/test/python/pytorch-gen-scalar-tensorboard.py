import torch
from torch.utils.tensorboard import SummaryWriter
import numpy as np

# 创建 SummaryWriter 对象，指定日志保存目录
writer = SummaryWriter('./data/simulated_training')

# 模拟训练参数
num_epochs = 100
steps_per_epoch = 10

for epoch in range(num_epochs):
    for step in range(steps_per_epoch):
        # 模拟损失值，随着训练进行损失逐渐减小
        loss = np.exp(-(epoch * steps_per_epoch + step) / 100) + np.random.normal(0, 0.1)
        # 模拟准确率，随着训练进行准确率逐渐提高
        accuracy = 1 - np.exp(-(epoch * steps_per_epoch + step) / 100) + np.random.normal(0, 0.05)
        accuracy = np.clip(accuracy, 0, 1)

        # 计算全局步数
        global_step = epoch * steps_per_epoch + step

        # 将损失值和准确率写入 TensorBoard 日志
        writer.add_scalar('Loss/train', loss, global_step)
        writer.add_scalar('Accuracy/train', accuracy, global_step)

# 关闭 SummaryWriter
writer.close()

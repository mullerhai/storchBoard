import torch
from torch.utils.tensorboard import SummaryWriter
import numpy as np

# 创建 SummaryWriter 对象，指定日志保存目录
writer = SummaryWriter('./data/simulated_tensor_training')

# 模拟训练参数
num_epochs = 100
steps_per_epoch = 10

for epoch in range(num_epochs):
    for step in range(steps_per_epoch):
        # 计算全局步数
        global_step = epoch * steps_per_epoch + step

        # 模拟损失值，随着训练进行损失逐渐减小
        loss = np.exp(-global_step / 100) + np.random.normal(0, 0.1)
        loss_tensor = torch.tensor(loss, dtype=torch.float32)
        # writer.add_scalar('Loss/train', loss_tensor, global_step)
        writer.add_tensor('Loss/train', loss_tensor, global_step)

        # 模拟准确率，随着训练进行准确率逐渐提高
        accuracy = 1 - np.exp(-global_step / 100) + np.random.normal(0, 0.05)
        accuracy = np.clip(accuracy, 0, 1)
        accuracy_tensor = torch.tensor(accuracy, dtype=torch.float32)
        # writer.add_scalar('Accuracy/train', accuracy_tensor, global_step)
        writer.add_tensor('Accuracy/train', accuracy_tensor, global_step)

# 关闭 SummaryWriter
writer.close()

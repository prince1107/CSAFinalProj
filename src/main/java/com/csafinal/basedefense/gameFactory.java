package com.csafinal.basedefense;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.components.HealthIntComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.csafinal.basedefense.Components.PlayerComponent;
import javafx.geometry.Point2D;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGL.entityBuilder;


public class gameFactory implements EntityFactory{

    @Spawns("Player")
    public Entity spawnPlayer(SpawnData data){
        HealthIntComponent hp = new HealthIntComponent(10);
        return entityBuilder()
                .type(DropApp.Type.BUILDING)
                .at(100, 100)
                .with(hp)
                .viewWithBBox("bucket.png")
                .collidable()
                .with(new PlayerComponent())
                .build();
    }

    @Spawns("Drops")
    public Entity spawnDrops(SpawnData data ){
        int xval = FXGLMath.random(0, getAppWidth() - 64);
        int yval = 0;
        int targetx = 200;
        int targety = 200;
        System.out.println(xval);
        return entityBuilder()
                .type(DropApp.Type.ENEMY)
                .at(xval, yval)
                .with(new ProjectileComponent(new Point2D((int) (targetx - xval), (int) (targety - yval)), 150))
                .viewWithBBox("droplet.png")
                .collidable()
                .build();
    }

}

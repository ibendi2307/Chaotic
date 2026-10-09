package com.example.chaotic.Utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RaycastUtil {
    public static List<EntityHitResult> getAllEntityHitResults(Entity shooter, Vec3 startPos, Vec3 endPos, AABB boundingBox, Predicate<Entity> filter) {
        List<EntityHitResult> hits = new ArrayList<>();
        Level level = shooter.level();

        List<Entity> entitiesInRange = level.getEntities(shooter, boundingBox, filter);

        for (Entity targetEntity : entitiesInRange) {
            AABB targetBox = targetEntity.getBoundingBox().inflate(targetEntity.getPickRadius());

            Optional<Vec3> clipResult = targetBox.clip(startPos, endPos);

            if (clipResult.isPresent()) {
                hits.add(new EntityHitResult(targetEntity, clipResult.get()));
            }
        }

        hits.sort((hit1, hit2) -> Double.compare(
                startPos.distanceToSqr(hit1.getLocation()),
                startPos.distanceToSqr(hit2.getLocation())
        ));

        return hits;
    }
}

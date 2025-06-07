package com.logistica.tracking.repository;

import com.logistica.tracking.model.Package;
import java.util.Optional;

public interface PackageRepository {
    Optional<Package> findByTrackingNumber(String trackingNumber);
}